package com.rp199.vault;

import static com.rp199.vault.Vault.MAX_PASSWORD;

public class DescendingHackerThread extends HackerThread {

    public DescendingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for (int i = MAX_PASSWORD; i >=0 ; i--) {
            if(vault.isCorrectPassword(i)){
                System.out.println(this.getName() + " guessed the password " + i);
                System.exit(0);
            }
        }
    }
}
