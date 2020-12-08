package com.nextstep.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NormalMode implements Mode {
    private static final String DEFAULT_SEPARATOR = "[:,]";

    @Override
    public Numbers parseToNumbers(final String value) {
        return new Numbers(separateNumbers(value));
    }

    private List<Number> separateNumbers(final String value) {
        return Arrays.stream(value.split(DEFAULT_SEPARATOR))
                .map(Number::of)
                .collect(Collectors.toList());
    }
}
