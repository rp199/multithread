package com.rp199.atomic.reference;

import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static void main(String[] args) {
        String oldName = "oldName";
        String newName = "newName";

        AtomicReference<String> atomicReference = new AtomicReference<>(oldName);
        atomicReference.set("asdasdasd");
        if (atomicReference.compareAndSet(oldName, newName)) {
            System.out.println("New value " + atomicReference.get());
        } else {
            System.out.println("Nothing change");
        }
    }
}
