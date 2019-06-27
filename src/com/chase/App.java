package com.chase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {
    private final String filepath;
    private final Producer producer;
    private final Consumer consumer;

    Queue<String> queue;

    public App(String file) {
        this.filepath = file;
        this.queue = new LinkedList<>();

        this.producer = new ProducerImpl(queue);
        this.consumer = new ConsumerImpl(queue);
    }

    public void Run() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(this.filepath))) {
            while(scanner.hasNext()){
                this.producer.Produce(scanner.nextLine());
            }
        }
        int count = 0;

        while (consumer.consume()) {
            count++;

            if (count % 10 == 0) {
                System.out.println("---------------------------------------------");
                System.out.println("Report after 10 messages processed");
                for(Map.Entry<String, List<Sale>> item : consumer.getSaleLogs().entrySet()) {
                    int totalValue = item.getValue().stream().map(Sale::getTotal).reduce(0, Integer::sum);
                    int totalQuantity = item.getValue().stream().map(Sale::getQuantity).reduce(0, Integer::sum);
                    System.out.println(item.getKey() + ":");
                    System.out.println("      Sales:       " + totalQuantity);
                    System.out.println("      Total Value: " + totalValue);
                }
            } else if (count == 50) {
                System.out.println("---------------------------------------------");
                System.out.println("50 messages reached. Stop accepting messages.");
                System.out.println("Report of the adjustments");

                for(Map.Entry<String, List<Sale>> item : consumer.getSaleLogs().entrySet()) {
                    int totalValue = item.getValue().stream().map(Sale::getAdjustedTotal).reduce(0, Integer::sum);
                    int totalQuantity = item.getValue().stream().map(Sale::getQuantity).reduce(0, Integer::sum);

                    System.out.println(item.getKey() + ":");
                    System.out.println("      Sales:       " + totalQuantity);
                    System.out.println("      Total Value: " + totalValue);
                }

                break;
            }
        }
    }
}
