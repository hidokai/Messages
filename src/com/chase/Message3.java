package com.chase;

import java.util.List;

public class Message3 extends Message {
    public Message3(String type, String op, int value) {
        super(type);
        this.op = op;
        this.value = value;
    }

    private String op;
    private int value;

    @Override
    public void accept(List<Sale> sales) {
        for(Sale sale : sales){
            switch(op) {
                case "add":
                    sale.setAdjustedPrice(sale.getPrice() + value);
                    break;
                case "sub":
                    sale.setAdjustedPrice(sale.getPrice() - value);
                    break;
                case "mul":
                    sale.setAdjustedPrice(sale.getPrice() * value);
                    break;
            }
        }
    }
}
