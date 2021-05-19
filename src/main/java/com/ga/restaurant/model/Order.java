package com.ga.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "orders")
//@IdClass(OrderPk.class)
public class Order {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //many orders can belong to one user
   // @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    //@Id
    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonIgnore
    private Item item;

    @Column
    String orderStatus;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    private Calendar createdDate;

    @Column
    private Integer itemQuantity;

    @Column
    private String orderType;

    public Order() {

    }

    public Order(Long id, User user, Item item, String orderType, Integer itemQuantity, String orderStatus, Calendar createdDate) {
        this.id = id;
        this.user = user;
        this.item = item;
        this.orderType = orderType;
        this.itemQuantity = itemQuantity;
        this.orderStatus = orderStatus;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Calendar getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", item=" + item +
                '}';
    }



}
