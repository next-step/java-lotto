package com.calc.model;

public class StringAddCalculator {

    private static final int ZERO_NUMBER = 0;

    public int add(String inputValue) {

        String[] inputValues = inputValue.split(",|:");
        int result = ZERO_NUMBER;
        for (String number : inputValues) {
            result += Integer.parseInt(number);
        }

        return result;
    }
}
