package com.rp199.vault;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HackerGame {
    public static void main(String[] args) {
        Random random = new Random();
        int password = random.nextInt(Vault.MAX_PASSWORD);
        System.out.println(password);
        Vault vault = new Vault(password);


        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());
        threads.forEach(Thread::start);
    }
}
