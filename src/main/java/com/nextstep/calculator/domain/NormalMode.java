package com.nextstep.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NormalMode implements Mode {
    private static final String DEFAULT_SEPARATOR = "[:,]";

    private final String value;

    public NormalMode(final String value) {
        this.value = value;
    }

    @Override
    public Numbers parseToNumbers() {
        return new Numbers(separateNumbers(value));
    }

    private List<Number> separateNumbers(final String value) {
        return Arrays.stream(value.split(DEFAULT_SEPARATOR))
                .map(Number::of)
                .collect(Collectors.toList());
    }
}
