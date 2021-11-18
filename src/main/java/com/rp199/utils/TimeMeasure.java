package com.rp199.utils;

public final class TimeMeasure {

    private TimeMeasure() {
    }

    public static long measure(Runnable operation) {
        long start = System.currentTimeMillis();
        operation.run();
        long end = System.currentTimeMillis();
        return end - start;
    }

}
