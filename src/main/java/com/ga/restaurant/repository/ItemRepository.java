package com.ga.restaurant.repository;

import com.ga.restaurant.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findItemById(Long id);
}
