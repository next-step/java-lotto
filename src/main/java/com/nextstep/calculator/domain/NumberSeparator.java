package com.nextstep.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberSeparator {
    private final Mode mode;

    public NumberSeparator(Mode mode) {
        this.mode = mode;
    }

    public Numbers separateNumbers() {
        List<Number> numbers = Arrays.stream(mode.extractSeparateTarget().split(mode.extractSeparator()))
                .map(Number::of)
                .collect(Collectors.toList());

        return new Numbers(numbers);
    }
}
