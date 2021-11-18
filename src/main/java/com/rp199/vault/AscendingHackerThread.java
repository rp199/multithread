package com.rp199.vault;

public class AscendingHackerThread extends HackerThread{

    public AscendingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for (int i = 0; i < Vault.MAX_PASSWORD ; i++) {
            if(vault.isCorrectPassword(i)){
                System.out.println(this.getName() + " guessed the password " + i);
                System.exit(0);
            }
        }
    }
}
