package com.rp199.vault;

public class PoliceThread extends Thread {

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        System.out.println("Game over bitches!!!!");
        System.exit(0);
    }
}
