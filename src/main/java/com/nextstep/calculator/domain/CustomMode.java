package com.nextstep.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomMode implements Mode {
    private final String value;
    private final String customSeparator;

    public CustomMode(final String value, final String customSeparator) {
        this.value = value;
        this.customSeparator = customSeparator;
    }

//    @Override
//    public Numbers parseToNumbers() {
//        return new Numbers(separateNumbers(value));
//    }
//
//    private List<Number> separateNumbers(final String value) {
//        return Arrays.stream(value.split(customSeparator))
//                .map(Number::of)
//                .collect(Collectors.toList());
//    }

    @Override
    public String extractSeparator() {
        return this.customSeparator;
    }

    @Override
    public String extractSeparateTarget() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomMode that = (CustomMode) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(customSeparator, that.customSeparator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, customSeparator);
    }

    @Override
    public String toString() {
        return "CustomMode{" +
                "value='" + value + '\'' +
                ", customSeparator='" + customSeparator + '\'' +
                '}';
    }
}
