package com.step2;

import java.util.regex.Pattern;

public class PositiveNumber {
    private static final String ONLY_ZERO_POSITIVE_PATTERN = "^[0-9]+$";

    private final Pattern pattern;
    private final String number;

    public PositiveNumber(String number) {
        this.number = number;
        this.pattern = Pattern.compile(ONLY_ZERO_POSITIVE_PATTERN);
        validatePositiveNumber(this.number);
    }

    private void validatePositiveNumber(String number) {
        if(!pattern.matcher(number).find()) {
            throw new RuntimeException();
        }
    }

    public String number() {
        return this.number;
    }
}
