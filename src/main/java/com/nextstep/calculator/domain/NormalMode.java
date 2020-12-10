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
    public String extractSeparator() {
        return DEFAULT_SEPARATOR;
    }

    @Override
    public String extractSeparateTarget() {
        return this.value;
    }
}
