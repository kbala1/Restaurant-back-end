package com.ga.restaurant.repository;

import com.ga.restaurant.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
     Order getOrderById(Long orderId);
     Order getOrderByUserId(Long userId);
     List<Order> getOrdersByUserId(Long userId);

}
