package calculator;

import calculator.exception.NumberOutOfRangeException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Number {

    public static final int MIN_VALUE = 0;

    private static final Map<Integer, Number> CACHE = new HashMap<>();

    private final int value;

    private Number(final int value) {
        this.value = value;
    }

    public static Number valueOf(final int value) {
        if (value < MIN_VALUE) {
            throw new NumberOutOfRangeException(value);
        }
        return CACHE.computeIfAbsent(value, Number::new);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        final Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
