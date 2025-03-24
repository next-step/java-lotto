package lotto.domain;

import java.util.Objects;

public class Number {
    private final long value;

    public Number(long value) {
        this.value = value;
    }

    public Number add(Number other) {
        return new Number(this.value + other.value);
    }

    public Number subtract(Number other) {
        return new Number(this.value - other.value);
    }

    public Number multiply(Number other) {
        return new Number(this.value * other.value);
    }

    public Number divide(Number other) {
        if (this.value % other.value != 0)
            throw new ArithmeticException();
        return new Number(this.value / other.value);
    }

    public long getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
