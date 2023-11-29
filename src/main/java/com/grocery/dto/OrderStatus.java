package com.grocery.dto;

public  class OrderStatus {
        private int itemId;
        private boolean ordered;
        private String statusOfOrder;

    public OrderStatus() {
    }

    public OrderStatus(int itemId, boolean ordered, String failureReason) {
            this.itemId = itemId;
            this.ordered = ordered;
            this.statusOfOrder = failureReason;
        }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public String getStatusOfOrder() {
        return statusOfOrder;
    }

    public void setStatusOfOrder(String statusOfOrder) {
        this.statusOfOrder = statusOfOrder;
    }
}

