package calculator;

import java.util.Objects;

public class Number {
    private final int value;

    public Number(String value) {
        this.value = Integer.parseInt(value);
    }

    public Number(int value) {
        this.value = value;
    }

    public Number plus(Number other) {
        return new Number(this.value + other.value);
    }

    public Number minus(Number other) {
        return new Number(this.value - other.value);
    }

    public Number multiply(Number other) {
        return new Number(this.value * other.value);
    }

    public Number divide(Number other) {
        return new Number(this.value / other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return value == number1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getValue() {
        return this.value;
    }
}
