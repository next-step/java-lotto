package com.nextstep.lotto.calculator;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final String DELIMITER = "[,:]";

    public static int splitAndSum(String source) {
        if (source == null || "".equals(source)) {
            return ZERO;
        }
        return parseAndAdd(source);
    }

    private static int parseAndAdd(String source) {
        String[] numbers = source.split(DELIMITER);
        int result = 0;
        for (String number : numbers) {
            result += parseInt(number);
        }
        return result;
    }

    private static int parseInt(String number) {
        return Integer.parseInt(number);
    }
}
