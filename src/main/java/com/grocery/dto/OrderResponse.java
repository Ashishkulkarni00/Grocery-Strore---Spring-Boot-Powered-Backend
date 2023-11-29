package com.grocery.dto;

import java.util.*;

public class OrderResponse {
        private List<OrderStatus> orderStatusList;

        public OrderResponse() {
            this.orderStatusList = new ArrayList<>();
        }

        public List<OrderStatus> getOrderStatusList() {
            return orderStatusList;
        }

    public void setOrderStatusList(List<OrderStatus> orderStatusList) {
        this.orderStatusList = orderStatusList;
    }
}


