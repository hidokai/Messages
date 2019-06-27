package com.chase;

import java.util.List;

public class Message2 extends Message {
    public Message2(String type, int total, int value) {
        super(type);

        this.total = total;
        this.value = value;
    }
    private int total;
    private int value;

    @Override
    public void accept(List<Sale> sales) {
        sales.add(new Sale(getType(), total, value));
    }
}
