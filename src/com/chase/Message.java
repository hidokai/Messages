package com.chase;

import java.util.List;

public abstract class Message {
    public Message(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    private String type;

    public abstract void accept(List<Sale> sales);
}
