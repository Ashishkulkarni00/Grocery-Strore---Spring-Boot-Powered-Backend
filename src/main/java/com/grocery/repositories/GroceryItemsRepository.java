package com.grocery.repositories;

import com.grocery.entities.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryItemsRepository extends JpaRepository<GroceryItem,Integer> {
}
