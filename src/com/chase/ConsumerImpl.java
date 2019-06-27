package com.chase;

import java.util.*;

public class ConsumerImpl implements Consumer {
    private final Queue<String> queue;

    public Map<String, List<Sale>> getSaleLogs() {
        return saleLogs;
    }

    private Map<String, List<Sale>> saleLogs;

    public ConsumerImpl(Queue<String> queue) {
        this.saleLogs =  new HashMap<>();
        this.queue = queue;
    }

    public boolean consume() {
        if (queue.isEmpty())
            return false;

        Message message = MessageParser.parse(queue.poll());
        List<Sale> sales;

        if (saleLogs.containsKey(message.getType())) {
            sales = saleLogs.get(message.getType());
        } else {
            sales = new ArrayList<>();
            saleLogs.put(message.getType(), sales);
        }

        message.accept(sales);

        return true;
    }
}
