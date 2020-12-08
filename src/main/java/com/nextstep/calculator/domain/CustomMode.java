package com.nextstep.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomMode implements Mode {
    private final String customSeparator;

    public CustomMode(final String customSeparator) {
        this.customSeparator = customSeparator;
    }

    @Override
    public Numbers parseToNumbers(final String value) {
        return new Numbers(separateNumbers(value));
    }

    private List<Number> separateNumbers(final String value) {
        return Arrays.stream(value.split(customSeparator))
                .map(Number::of)
                .collect(Collectors.toList());
    }
}
