package com.rp199.interrupt;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());

        thread.start();
        thread.interrupt();


        Thread longThread = new Thread(new LongComputationTask(new BigInteger("3"), new BigInteger("3")));
        //makes the thread to not block the application
        //longThread.setDaemon(true);
        longThread.start();
        //longThread.interrupt();
    }
}
