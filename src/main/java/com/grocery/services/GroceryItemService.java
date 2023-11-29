package com.grocery.services;

import com.grocery.entities.GroceryItem;
import com.grocery.exceptions.InvalidGroceryException;
import com.grocery.repositories.GroceryItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {

    @Autowired
    GroceryItemsRepository groceryItemsRepository;

    public GroceryItem addGrocery(GroceryItem groceryItem){
        double temp = 0.0d;
        if(Double.compare(groceryItem.getItemPrice(),temp)  == 0 || groceryItem.getItemName().isEmpty() || groceryItem.getItemQuantity() <= 0 ){
            throw new InvalidGroceryException("Provide all the grocery details");
        }else{
           return groceryItemsRepository.save(groceryItem);
        }
    }

    public GroceryItem updateGroceryItem(int id, GroceryItem groceryItem){
        double temp = 0.0d;
        if(groceryItem.getItemQuantity() <= 0 || groceryItem.getItemName().isEmpty()){
            throw new InvalidGroceryException("please provide valid item details");
        }
        if(groceryItemsRepository.existsById(id)){
            GroceryItem existingGroceryItem = groceryItemsRepository.findById(id).get();
            existingGroceryItem.setItemDescription(groceryItem.getItemDescription());
            existingGroceryItem.setItemName(groceryItem.getItemName());
            if(Double.compare(groceryItem.getItemPrice(),temp) == 0){
                throw new InvalidGroceryException("please provide valid price for the item");
            }else {
                existingGroceryItem.setItemPrice(groceryItem.getItemPrice());
            }
            existingGroceryItem.setItemQuantity(groceryItem.getItemQuantity());
            return groceryItemsRepository.save(existingGroceryItem);
        }else{
            throw new InvalidGroceryException("Grocery with given id " + id + " does not found");
        }
    }

    public GroceryItem getGroceryItemById(int id){
        if(groceryItemsRepository.existsById(id)){
            return groceryItemsRepository.findById(id).get();
        }else{
            throw new InvalidGroceryException("Invalid grocery item id");
        }
    }

    public List<GroceryItem> getAllGroceryItems(){
        List<GroceryItem> itemList = groceryItemsRepository.findAll();
        if(itemList == null){
            throw new InvalidGroceryException("No Groceries Available");
        }else{
            return itemList;
        }
    }

    public String deleteGroceryById(int id){
        if(groceryItemsRepository.existsById(id)){
            groceryItemsRepository.deleteById(id);
            return "Grocery item with given id " + id + " has been deleted";
        }else{
            throw new InvalidGroceryException("Invalid grocery item id");
        }
    }

}
