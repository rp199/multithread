package com.rp199.atomic.vol;

public class Metrics {
    private long count = 0;
    private volatile double average = 0.0;

    public synchronized void addSample(long sample) {
        double currentSum = average * count;
        count++;
        average = (currentSum + sample) / count;
    }

    public double getAverage() {
        return average;
    }
}
