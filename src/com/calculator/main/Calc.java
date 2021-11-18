package com.calculator.main;

public class Calc {
    public static String calculate(String valOne, String valTwo, String opSign) {
        Converter conv = new Converter();
        Integer oneOp = conv.stringToInteger(valOne);
        Integer twoOp = conv.stringToInteger(valTwo);
        if (oneOp <= 10 && twoOp <= 10) {
            switch (opSign) {
                case "+":
                    return conv.integerToString(oneOp + twoOp);
                case "-":
                    return conv.integerToString(oneOp - twoOp);
                case "*":
                    return conv.integerToString(oneOp * twoOp);
                case "/":
                    return conv.integerToString(oneOp / twoOp);
                default:
                    throw new RuntimeException("\ud83d\udde8\ufe0f " + "Неподдерживаемая операция!");
            }
        } else {
            throw new RuntimeException("\ud83d\udde8\ufe0f " + "Введенное значение превышает допустимое.");
        }
    }
}
