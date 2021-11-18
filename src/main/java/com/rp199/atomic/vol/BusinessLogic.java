package com.rp199.atomic.vol;

import com.rp199.utils.TimeMeasure;

import java.util.Random;

public class BusinessLogic extends Thread {

    private Metrics metrics;
    private Random random = new Random();

    public BusinessLogic(Metrics metrics) {
        this.metrics = metrics;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    @Override
    public void run() {
        while (true) {
            long elapsedTime = TimeMeasure.measure(() -> {
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            metrics.addSample(elapsedTime);
        }
    }
}
