package com.jaenyeong.mission01.calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static final int NONE = 0;

    public List<Integer> parseToNumbers(final String exp) {
        final List<Integer> numbers = new ArrayList<>();

        if (isBlank(exp)) {
            numbers.add(NONE);
            return numbers;
        }

        return numbers;
    }

    protected boolean isBlank(final String exp) {
        return (exp == null) || (exp.trim().isEmpty());
    }
}
