package com.chase;a

class Sale {
    private int adjustedPrice;
    private int price;
    private String type;
    private int quantity;

    public Sale(String type, int quantity, int price) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.adjustedPrice = price;
    }

    public String getType() {
        return type;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getPrice() {
        return price;
    }
    public int getTotal() {
        return quantity * price;
    }

    public void setAdjustedPrice(int adjustedPrice) {
        this.adjustedPrice = adjustedPrice;
    }
    public int getAdjustedTotal() {
        return adjustedPrice * quantity;
    }
}