package com.rp199.thread101;

public class Thread101 {

    public static void main(String[] args) throws InterruptedException {

        //firstExample();
        //uncaughtException();
        //threadInheritance();
        //threadInheritance();
    }

    private static void firstExample() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside " + Thread.currentThread().getName());
                System.out.println("Priority:" + Thread.currentThread().getPriority());
            }
        });

        thread.setName("Worked thread 1");
        thread.setPriority(Thread.MAX_PRIORITY);

        Thread thread1 = new Thread(() -> System.out.println("Hi second thread " + Thread.currentThread().getName()));
        thread1.setName("Lambda thread 1");

        System.out.println("We are in thread " + Thread.currentThread().getName() + "before starting a new thread");
        thread.start();
        thread1.start();
        System.out.println("We are in thread " + Thread.currentThread().getName() + "after starting a new thread");
        Thread.sleep(10000);
    }

    private static void uncaughtException(){
        Thread thread = new Thread(() -> {
            System.out.println("Inside" + Thread.currentThread().getName());
            throw new RuntimeException("BOOOM!!!!");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Inside" + Thread.currentThread().getName());
            throw new RuntimeException("BOOOM2!!!!");
        });

        thread.setName("Broken Thread");

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread " + t.getName() + " the error is " + e.getMessage());
            }
        });

        thread2.setUncaughtExceptionHandler((t, e) -> System.out.println("A critical error happened in thread " +
                t.getName() + " the error is " + e.getMessage()));

        thread2.start();
        thread.start();
    }

    private static void threadInheritance(){
        Thread thread = new NewThread();
        thread.start();
    }

    private static class NewThread extends Thread{
        @Override
        public void run(){
            System.out.println("Hello from " + this.getName());
        }
    }
}
