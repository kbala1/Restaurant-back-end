package com.ga.restaurant.model.request;

import java.util.List;

public class OrderRequest {
    String firstName;
    String lastName;
    String address;
    String phoneNo;
    String orderType;
    List<ItemRequest> items;
    double totalPayment;
    String creditCardNo;

    public OrderRequest(){}


    public OrderRequest(String firstName, String lastName, String address, String phoneNo,
                        String orderType, List<ItemRequest> items, double totalPayment,
                        String creditCardNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.orderType = orderType;
        this.items = items;
        this.totalPayment = totalPayment;
        this.creditCardNo = creditCardNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public List<ItemRequest> getItems() {
        return items;
    }

    public void setItems(List<ItemRequest> items) {
        this.items = items;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
