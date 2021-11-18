package com.rp199.atomic.stack;

public interface CustomStack<T> {

    void push(T value);

    T pop();

    int getCounter();

}
