package com.rp199.atomic.vol;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Metrics metrics = new Metrics();

        BusinessLogic b1 = new BusinessLogic(metrics);
        BusinessLogic b2 = new BusinessLogic(metrics);
        BusinessLogic b3 = new BusinessLogic(metrics);

        MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);
//        b1.start();
//        b2.start();
//        b3.start();
//        metricsPrinter.start();

        MinMaxMetrics a = new MinMaxMetrics();


        while (true) {
            long number = new Random().nextInt(1000);
            System.out.println("Number" + number);
            Thread thread = new Thread(() -> a.addSample(number));
            thread.start();
            System.out.println("Max" + a.getMax() + " Min " + a.getMin());
            //Thread.sleep(10);
        }
    }
}
