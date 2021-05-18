package com.ga.restaurant.model.request;

public class ItemRequest {
    Long itemId;
    int itemQuantity;

    public ItemRequest(){}

    public ItemRequest(Long itemId, int itemQuantity) {
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
