package com.rp199.atomic.stack.lock;

import com.rp199.atomic.stack.CustomStack;
import com.rp199.atomic.stack.StackNode;

public class StandardStack<T> implements CustomStack<T> {
    private StackNode<T> head;
    private int counter = 0;

    public synchronized void push(T value) {
        StackNode<T> newHead = new StackNode<>(value);
        newHead.next = head;
        head = newHead;
        counter++;
    }

    public synchronized T pop() {
        if (head == null) {
            counter++;
            return null;
        }

        T value = head.value;
        head = head.next;
        counter++;
        return value;
    }

    public int getCounter() {
        return counter;
    }
}
