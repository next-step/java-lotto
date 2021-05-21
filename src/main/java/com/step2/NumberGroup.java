package com.step2;

import java.util.regex.Pattern;

public final class NumberGroup {
    private static final String ONLY_ZERO_POSITIVE_PATTERN = "^[0-9]+$";
    private final Pattern pattern;
    private final String[] tokens;

    public NumberGroup(String[] tokens) {
        this.tokens = tokens;
        this.pattern = Pattern.compile(ONLY_ZERO_POSITIVE_PATTERN);
    }

    public int calculateAddition() {
        int sum = 0;

        for (String sNumber : tokens) {
            validatePositiveNumber(sNumber);
            sum += Integer.parseInt(sNumber);
        }

        return sum;
    }

    private void validatePositiveNumber(String number) {
        if(!pattern.matcher(number).find()) {
            throw new RuntimeException();
        }
    }
}
