package com.chase;

import java.util.List;

public class Message1 extends Message {
    public Message1(String type, int value) {
        super(type);
        this.value = value;
    }

    private int value;

    public void accept(List<Sale> sales) {
        sales.add(new Sale(getType(), 1, value));
    }
}
