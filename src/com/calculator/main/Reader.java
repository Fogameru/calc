package com.calculator.main;

import java.util.Scanner;

public class Reader {
    private String valOne;
    private String valTwo;
    private String opSign;

    public Reader() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Введите формулу (прим: 3 + 7 или I * V)");
        String equation = scr.nextLine().toUpperCase();
        String[] num = equation.split(" ");
        valOne = num[0];
        valTwo = num[2];
        opSign = num[1];
        if (num.length > 3) {
            throw new RuntimeException("Допустим только один оператор.");
        }
    }

    public String getValOne() {
        return valOne;
    }

    public String getValTwo() {
        return valTwo;
    }

    public String getOpSign() {
        return opSign;
    }
}
