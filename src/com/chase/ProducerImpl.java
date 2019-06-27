package com.chase;

import java.util.Queue;

public class ProducerImpl implements Producer {
    private final Queue<String> queue;

    public ProducerImpl(Queue<String> queue) {
        this.queue = queue;
    }

    public void Produce(String message) {
        this.queue.add(message);
    }
}
