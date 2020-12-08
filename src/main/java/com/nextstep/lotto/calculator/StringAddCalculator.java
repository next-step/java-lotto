package com.nextstep.lotto.calculator;

public class StringAddCalculator {
    private static final int ZERO = 0;

    public static int splitAndSum(String source) {
        if (source == null || "".equals(source)) {
            return ZERO;
        }
        return parseInt(source);
    }

    private static int parseInt(String number) {
        return Integer.parseInt(number);
    }
}
