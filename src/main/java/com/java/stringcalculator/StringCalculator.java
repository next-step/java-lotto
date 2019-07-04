package com.java.stringcalculator;

public class StringCalculator {
    private static final int INITIAL_NUMBER = 0;

    public int calculator(String input) {
        if (input == null || input.isEmpty()) {
            return INITIAL_NUMBER;
        }
        String[] numbers = StringParser.separatorParser(input);
        int sum = INITIAL_NUMBER;
        for (String number : numbers) {
            sum = new Number(number).add(sum);
        }
        return sum;
    }

}
