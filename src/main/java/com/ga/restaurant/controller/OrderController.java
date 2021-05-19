package com.ga.restaurant.controller;
import com.ga.restaurant.model.Order;
import com.ga.restaurant.model.request.OrderRequest;
import com.ga.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    // Get all the orders by a orderId
    @GetMapping(path = "orders/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        System.out.println("Calling getOrderListByUser");
        return orderService.getOrderById(orderId);
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody OrderRequest orderRequestObject) {
        System.out.println("Calling CreateOrder");
        return orderService.createOrder(orderRequestObject);
    }

    @GetMapping(path = "user/{phoneNo}")
    public List<Order> getOrderByPhone(@PathVariable String phoneNo) {
        System.out.println("Calling getOrderByPhone");
        return orderService.getOrdersByPhoneNo(phoneNo);
    }
}

