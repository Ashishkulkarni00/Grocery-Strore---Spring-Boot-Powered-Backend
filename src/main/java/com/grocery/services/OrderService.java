package com.grocery.services;
import com.grocery.dto.OrderResponse;
import com.grocery.dto.OrderStatus;
import com.grocery.entities.GroceryItem;
import com.grocery.entities.Order;
import com.grocery.entities.OrderItem;
import com.grocery.exceptions.InvalidOrderException;
import com.grocery.repositories.GroceryItemsRepository;
import com.grocery.repositories.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRespository orderRespository;

    @Autowired
    GroceryItemsRepository groceryItemsRepository;

    public OrderResponse placeOrder(Order order){

        System.out.println();

        if(order.getItemList().isEmpty()){
            throw new InvalidOrderException("Please provide the id's of items you want to order");
        }else{
            OrderResponse orderResponse = new OrderResponse();
            List<OrderStatus> statusList = new ArrayList<>();
            for(int i = 0; i < order.getItemList().size(); i++){

                OrderItem  orderItem = order.getItemList().get(i);

                OrderStatus orderStatus = new OrderStatus();

                if(groceryItemsRepository.existsById(orderItem.getItemId())){
                    //Item Exists
                    GroceryItem existingItem = groceryItemsRepository.findById(orderItem.getItemId()).get();
                    if(existingItem.getItemQuantity() >= orderItem.getBuyQuantity()){
                        // order can be placed
                        orderStatus.setOrdered(true);
                        orderStatus.setItemId(orderItem.getItemId());
                        orderStatus.setStatusOfOrder("Order for the item has been placed");
                        statusList.add(orderStatus);
                        updateInventory(orderItem);

                    }else{
                        //order cannot be placed
                        orderStatus.setOrdered(false);
                        orderStatus.setItemId(orderItem.getItemId());
                        orderStatus.setStatusOfOrder("Insufficient quantity available");
                        statusList.add(orderStatus);
                    }
                }else {
                    //Item does not exist
                    orderStatus.setOrdered(false);
                    orderStatus.setItemId(orderItem.getItemId());
                    orderStatus.setStatusOfOrder("Item you are looking for is not present at the moment");
                    statusList.add(orderStatus);
                }
            }
            if(statusList.size() == 0){
                throw new InvalidOrderException("Items you are looking are not present at the moment");
            }else{
                order.setOrderDescription("Order has been Successfully placed");
                orderRespository.save(order);
                orderResponse.setOrderStatusList(statusList);
            }
            return orderResponse;
        }
    }

    public void updateInventory(OrderItem orderItem){
        GroceryItem groceryItem = groceryItemsRepository.findById(orderItem.getItemId()).get();
        groceryItem.setItemQuantity(groceryItem.getItemQuantity() - orderItem.getBuyQuantity());
        groceryItemsRepository.save(groceryItem);
    }

}
