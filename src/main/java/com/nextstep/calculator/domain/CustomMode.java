package com.nextstep.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomMode implements Mode {
    private final String value;
    private final String customSeparator;

    public CustomMode(final String value, final String customSeparator) {
        this.value = value;
        this.customSeparator = customSeparator;
    }

    @Override
    public Numbers parseToNumbers() {
        return new Numbers(separateNumbers(value));
    }

    private List<Number> separateNumbers(final String value) {
        return Arrays.stream(value.split(customSeparator))
                .map(Number::of)
                .collect(Collectors.toList());
    }
}
