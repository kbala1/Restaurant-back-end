package com.ga.restaurant.model;

import java.io.Serializable;

public class OrderPk implements Serializable {
    Long id;
    Item item;
    User user;

    public OrderPk() {
    }

    public OrderPk(Long id, Item item, User user) {
        this.id = id;
        this.item = item;
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}



