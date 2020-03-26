package calculator;

import java.util.Objects;

public class Number {
    private int value;

    public Number(final String letter) {
        this.value = Integer.parseInt(letter);
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
