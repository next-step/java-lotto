package com.java.stringcalculator;

public class Number {
    Integer number;

    public Number(String number) {
        this.number = positiveValidator(numberValidator(number));
    }

    public int add(int number) {
        return this.number + number;
    }

    private int numberValidator(String number) {
        if (isNumber(number)) {
            return Integer.parseInt(number);
        }
        throw new RuntimeException("입력된 값이 숫자가 아닙니다.");
    }

    public static int positiveValidator(Integer number) {
        if (number > 0) {
            return number;
        }
        throw new RuntimeException("입력된 숫자가 음수 입니다.");
    }

    private static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
