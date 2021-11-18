package com.rp199.interrupt;

import static java.lang.Thread.sleep;

public class BlockingTask implements Runnable {
    @Override
    public void run() {
        try {
            sleep(5000000);
        } catch (InterruptedException e) {
            System.out.println("Exiting blocking thread");
        }
    }
}
