package com.rp199.deadlock;

import java.util.Random;

public class TrainA implements Runnable {

    private Intersection intersection;
    private Random random = new Random();

    public TrainA(Intersection intersection) {
        this.intersection = intersection;
    }

    @Override
    public void run() {
        while (true) {
            long sleepingTime = random.nextInt(5);
            try {
                Thread.sleep(sleepingTime);
            } catch (InterruptedException e) {
            }

            intersection.takeRoadA();
        }
    }
}
