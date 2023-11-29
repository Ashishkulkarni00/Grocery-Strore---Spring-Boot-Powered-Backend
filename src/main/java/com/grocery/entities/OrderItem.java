package com.grocery.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "orderedItems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int orderItemId;

    Integer itemId;

    String itemName;

    int buyQuantity;

    @ManyToOne
    @JoinColumn(name = "orderId")
    Order order;

    public OrderItem(int orderItemId, Integer itemId, String itemName, int buyQuantity) {
        this.orderItemId = orderItemId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.buyQuantity = buyQuantity;
    }

    public OrderItem() {
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(int buyQuantity) {
        this.buyQuantity = buyQuantity;
    }
}
