package com.pollra.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Separator {

    private final String value;

    public Separator(String text) {
        this.value = text;
    }

    public List<String> splitOf(String requestText) {
        String[] splitResult = requestText.split(value);
        return Arrays.asList(splitResult);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Separator)) return false;
        Separator separator=(Separator) o;
        return Objects.equals(value, separator.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Separator{" +
                "value='" + value + '\'' +
                '}';
    }
}
