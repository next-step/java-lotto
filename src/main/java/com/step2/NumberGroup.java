package com.step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class NumberGroup {
    private final List<PositiveNumber> tokens;

    public NumberGroup(String[] tokens) {
        this.tokens = Arrays.stream(tokens).map(PositiveNumber::new).collect(Collectors.toList());
    }

    public int calculateAddition() {
        int sum = 0;

        for (PositiveNumber positiveNumber : tokens) {
            sum += Integer.parseInt(positiveNumber.number());
        }

        return sum;
    }
}
