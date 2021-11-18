package com.rp199.join;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = List.of(0L, 23442L, 2324L, 23L, 5556L, 666666L);

        List<FactorialThread> threads = inputNumbers.stream()
                .map(FactorialThread::new).collect(Collectors.toList());


        for (FactorialThread thread1 : threads) {
            thread1.setDaemon(true);
            thread1.start();
        }

        for (FactorialThread thread : threads) {
            thread.join(2000);
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            var factorialThread = threads.get(i);

            if (factorialThread.isFinished()) {
                System.out.println("Fatorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
            }
        }
    }
}
