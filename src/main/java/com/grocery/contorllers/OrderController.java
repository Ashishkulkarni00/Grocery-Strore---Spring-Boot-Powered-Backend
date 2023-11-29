package com.grocery.contorllers;

import com.grocery.dto.OrderResponse;
import com.grocery.entities.Order;
import com.grocery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public OrderResponse placeOrder(@RequestBody Order order){
        System.out.println("order Object " + order.toString());
        return orderService.placeOrder(order);
    }
}
