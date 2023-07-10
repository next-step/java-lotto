package lotto;

import java.util.Objects;

public final class Number {

    private final int value;

    private Number(final int value) {
        this.value = value;
    }

    public static Number of(final int value) {
        return new Number(value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
