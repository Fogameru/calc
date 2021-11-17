package com.calculator.main;

public class Main {

    public static void main(String[] args) {
        Reader reader = new Reader();
        System.out.println(Calc.calculate(reader.getValOne(), reader.getValTwo(), reader.getOpSign()));

    }
}
