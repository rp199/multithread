package com.rp199.calculation;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var calc = new ComplexCalculation();

        System.out.println(calc.calculateResult(BigInteger.TWO, BigInteger.TWO, new BigInteger("3"), new BigInteger("3")));
    }
}
