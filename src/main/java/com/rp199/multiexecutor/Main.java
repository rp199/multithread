package com.rp199.multiexecutor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MultiExecutor multiExecutor = new MultiExecutor(List.of(
                () -> System.out.println(" Hi from" + Thread.currentThread().getName()),
                () -> System.out.println(" Hi from" + Thread.currentThread().getName()),
                () -> System.out.println(" Hi from" + Thread.currentThread().getName()),
                () -> System.out.println(" Hi from" + Thread.currentThread().getName())
        ));

        multiExecutor.executeAll();
    }
}
