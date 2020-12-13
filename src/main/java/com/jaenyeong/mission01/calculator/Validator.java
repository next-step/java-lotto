package com.jaenyeong.mission01.calculator;

public class Validator {
    private static final String ONLY_NATURAL_NUMBER_EXP = "^[0-9]$";

    private Validator() {
    }

    public static boolean isBlank(final String exp) {
        return (exp == null) || (exp.trim().isEmpty());
    }

    public static boolean isOneDigit(final String exp) {
        return (exp.length() == 1);
    }

    public static boolean isNaturalNumber(final String exp) {
        return exp.matches(ONLY_NATURAL_NUMBER_EXP);
    }
}
