package com.rp199.interrupt;

import java.math.BigInteger;
import java.util.stream.Stream;

public class LongComputationTask implements Runnable {

    private BigInteger base;
    private BigInteger power;

    public LongComputationTask(BigInteger base, BigInteger power) {
        this.base = base;
        this.power = power;
    }

    @Override
    public void run() {
        System.out.println(base + "^" + power + "=" + pow(base, power));
    }

    private BigInteger pow(BigInteger base, BigInteger power) {
        BigInteger result = BigInteger.ONE;

        for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Someone interrupted me!");
                return BigInteger.ZERO;
            }
            result = result.multiply(base);
        }
        return result;
    }

    private BigInteger powStream(BigInteger base, BigInteger power) {
        return Stream.iterate(BigInteger.ZERO, i -> i.add(BigInteger.ONE))
                .limit(power.longValue())
                .reduce(BigInteger.ONE, (bigInteger, bigInteger2) -> {
                    return bigInteger.multiply(base);
                });
    }
}
