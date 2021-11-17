package com.calculator.main;
import java.util.HashMap;

public class Converter {

    public Boolean isRoman = false;

    public Integer stringToInteger(String value) {
        if (isRomanNumber(value)) {
            isRoman = true;
            return romanToInt(value);
        }

        if (isRoman == Boolean.TRUE) {
            throw new RuntimeException("Ошибка конвертации строки в число!");
        }

        return Integer.valueOf(value);
    }

    public String integerToString(Integer value) {
        if (isRoman) {
            if (value <= 0) {
                throw new RuntimeException("Результат вычисления римских цифр не может быть меньше нуля!");
            }

            return intToRoman(value);
        }

        return String.valueOf(value);
    }

    private Boolean isRomanNumber(String value) {
        return (value.contains("I") || value.contains("V") || value.contains("X"));
    }

    private Integer romanToInt(String value) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);

        Integer sum = 0;

        for (int i =0; i < value.length(); i++) {
            if (value.charAt(i) == 'V' || value.charAt(i) == 'X') {
                if (i > 0 && value.charAt(i-1) == 'I') sum -= 2;
            }

            if (value.charAt(i) == 'L' || value.charAt(i) == 'C') {
                if (i > 0 && value.charAt(i-1) == 'I') sum -= 20;
            }

            sum += map.get(value.charAt(i));
        }

        return sum;
    }

    private String intToRoman(Integer value) {
        int[] romValues = {1, 4, 5, 9, 10, 40, 50, 90, 100};
        String[] rom = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = romValues.length-1; i >= 0 && value > 0; i--) {
            while (value >= romValues[i]) {
                value -= romValues[i];
                stringBuilder.append(rom[i]);
            }
        }

        return stringBuilder.toString();
    }
}

