package com.grocery.contorllers;

import com.grocery.entities.GroceryItem;
import com.grocery.services.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/groceries")
public class GroceryController {


    @Autowired
    GroceryItemService groceryItemService;
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<GroceryItem> getAllGroceries(){
        return groceryItemService.getAllGroceryItems();
    }

    @GetMapping("/{itemId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public GroceryItem getItemById(@PathVariable ("itemId") int id){
        return groceryItemService.getGroceryItemById(id);
    }

    @PutMapping("/{itemId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public GroceryItem updateItemById(@PathVariable ("itemId") int id,@RequestBody GroceryItem groceryItem){

        return groceryItemService.updateGroceryItem(id,groceryItem);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public GroceryItem addGrocery(@RequestBody GroceryItem groceryItem){
        return groceryItemService.addGrocery(groceryItem);
    }

    @DeleteMapping("/{itemId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteItemById(@PathVariable ("itemId") int id){
        return groceryItemService.deleteGroceryById(id);
    }
}
