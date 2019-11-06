package com.calc;

public class StringAddCalculator {

    private static final int ZERO_NUMBER = 0;

    public int add(String inputValue) {
        if (isNull(inputValue)) {
            inputValue = "0";
        }
        String[] inputValues = inputValue.split("[\\,\\:]");
        int result = ZERO_NUMBER;
        for (String number : inputValues) {
            result += Integer.parseInt(number);
        }

        return result;
    }

    private boolean isNull(String inputValue) {
        return (inputValue == null);
    }
}
