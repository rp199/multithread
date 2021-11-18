package com.rp199.semaphore;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int capacity = 8;
        var full = new Semaphore(0);
        var empty = new Semaphore(capacity);
        Queue<String> queue = new ArrayDeque<>();
        Lock lock = new ReentrantLock();

        Thread producer = new Thread(() -> {
            int count = 0;
            while (true) {
                try {
                    empty.acquire();
                    lock.lock();
                    try {
                        String item = "Item " + count++;
                        System.out.println("Producing: " + item);
                        queue.offer("Item " + count);
                    } finally {
                        lock.unlock();
                    }
                    full.release();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Runnable consumerAction = () -> {
            while (true) {
                try {
                    full.acquire();
                    lock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + " : " + queue.poll());
                    } finally {
                        lock.unlock();
                    }
                    Thread.sleep(10000);
                    empty.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        producer.start();
        Thread.sleep(2000);
        for (int i = 0; i < capacity; i++) {
            Thread thread = new Thread(consumerAction);
            thread.start();
        }
    }
}
