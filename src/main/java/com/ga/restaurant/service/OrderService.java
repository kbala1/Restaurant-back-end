package com.ga.restaurant.service;


import com.ga.restaurant.exception.DataNotFoundException;
import com.ga.restaurant.model.Item;
import com.ga.restaurant.model.Order;
import com.ga.restaurant.model.request.OrderRequest;
import com.ga.restaurant.model.User;
import com.ga.restaurant.repository.ItemRepository;
import com.ga.restaurant.repository.OrderRepository;
import com.ga.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) { this.itemRepository = itemRepository; }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(Long orderId) {
        System.out.println("Calling getOrderList");
        Order order = orderRepository.getOrderById(orderId);
        if (order == null) {
            throw new DataNotFoundException("Order with order " + orderId + " does not exist");
        }
        return order;
    }

    public Order createOrder(OrderRequest orderRequestObject) {
        System.out.println("Calling createOrder");

        // create user object from the user related fields in orderRequestObject
        User user = new User();
        user.setFirstName(orderRequestObject.getFirstName());
        user.setLastName(orderRequestObject.getLastName());
        user.setAddress(orderRequestObject.getAddress());
        user.setPhoneNo(orderRequestObject.getPhoneNo());

        // save user object to user table
        User createdUser = userRepository.save(user);

        // get items by itemIds
        List<Item> items = orderRequestObject.getItems().stream()
                .map(item -> itemRepository.findItemById(item.getItemId()))
                .filter(item -> item != null)
                .collect(Collectors.toList());

        if(items.isEmpty()) {
            throw new DataNotFoundException("None of the items exist");
        }

        // create order objects -- use user id from saved user
        List<Order> createdOrders = new ArrayList<>();
        //Long orderId = null;
        for(int i = 0; i<items.size(); i++){
            Order order = new Order();
            order.setUser(createdUser);
            order.setItem(items.get(i));
            order.setItemQuantity(orderRequestObject.getItems().get(i).getItemQuantity());
            order.setOrderType(orderRequestObject.getOrderType());

                // get id from first entry in order table for this order
                // because orderId is not unique in order table
                Order createdOrder = orderRepository.save(order);
                createdOrders.add(createdOrder);
//
        }

        return null;
    }

    public List<Order> getOrdersByPhoneNo(String phoneNo) {
        System.out.println("Calling getOrderByPhone");
        List<User> users = userRepository.getUsersByPhoneNo(phoneNo);

        if (users.isEmpty()) {
            throw new DataNotFoundException("User with phoneNo " + phoneNo + " not found");
        }

        List<Order> orders = users.stream()
                .map(user -> orderRepository.getOrdersByUserId(user.getId()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return orders;
    }

}
