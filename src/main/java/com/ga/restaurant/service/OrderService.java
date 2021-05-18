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

        // get items by itemIds -- this might not be necessary
        List<Item> items = orderRequestObject.getItems().stream()
                .map(item -> itemRepository.findItemById(item.getItemId()))
                .collect(Collectors.toList());
        //If itemId doesn't exist
       // Item item = itemRepository.findItemById(itemId);
//        if(item.isEmpty() {
//            throw new DataNotFoundException("Item with this itemId " + item.getItemId() + "doesn't exist");
//        }

        // create order objects -- use user id from saved user
        List<Order> createdOrders = new ArrayList<>();
        //Long orderId = null;
        for(int i = 0; i<items.size(); i++){
            Order order = new Order();
            order.setUser(createdUser);
            order.setItem(items.get(i));
            order.setItemQuantity(orderRequestObject.getItems().get(i).getItemQuantity());
            order.setOrderType(orderRequestObject.getOrderType());

//            if (orderId != null) {
//                order.setId(orderId);
//                createdOrders.add(orderRepository.save(order));
//            }
//            else {
                // get id from first entry in order table for this order
                // because orderId is not unique in order table
                Order createdOrder = orderRepository.save(order);
                createdOrders.add(createdOrder);
//               orderId = createdOrder.getId();
//            }
        }

        return null;
    }

    public Order getOrderByPhoneNo(String phoneNo) {
        System.out.println("Calling getOrderByPhone");
        User user = userRepository.getUserByPhoneNo(phoneNo);

        if (user == null) {
            throw new DataNotFoundException("User with phoneNo " + phoneNo + " not found");
        }

        Order order = orderRepository.getOrderByUserId(user.getId());
        return order;
    }

}
