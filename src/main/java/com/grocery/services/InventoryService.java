package com.grocery.services;

import com.grocery.entities.GroceryItem;
import com.grocery.entities.Inventory;
import com.grocery.exceptions.InvalidGroceryException;
import com.grocery.repositories.GroceryItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    GroceryItemsRepository groceryItemsRepository;


    public GroceryItem updateInventory(int id, Inventory inventory){
        if(groceryItemsRepository.existsById(id)){
            double temp = 0.0d;
            if(inventory.price - temp == 0 || inventory.getQuantity() < 0){
                throw  new InvalidGroceryException("Please provide valid details");
            }else {
                GroceryItem existingGroceryItem = groceryItemsRepository.findById(id).get();
                existingGroceryItem.setItemQuantity(inventory.getQuantity());
                existingGroceryItem.setItemPrice(inventory.getPrice());
                return groceryItemsRepository.save(existingGroceryItem);
            }

        }else{
            throw new InvalidGroceryException("Invalid item id provided");
        }
    }


}
