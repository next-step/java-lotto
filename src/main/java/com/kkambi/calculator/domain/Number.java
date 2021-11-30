package com.kkambi.calculator.domain;

public class Number {

    private final Integer number;

    public Number(String number) {
        this.number = parseNumber(number);
    }

    public Integer getNumber() {
        return number;
    }

    private int parseNumber(String token) {
        int number;
        try {
            number = Integer.parseInt(token);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException();
        }

        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
}
