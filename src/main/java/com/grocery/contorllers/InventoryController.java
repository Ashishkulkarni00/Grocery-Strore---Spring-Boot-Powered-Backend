package com.grocery.contorllers;

import com.grocery.entities.GroceryItem;
import com.grocery.entities.Inventory;
import com.grocery.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @PutMapping("/{itemId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public GroceryItem updateById(@PathVariable ("itemId") int id, @RequestBody Inventory inventory){
        return inventoryService.updateInventory(id,inventory);
    }
}
