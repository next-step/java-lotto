package me.devyonghee.calculator;

import java.util.Objects;

final class Number {

    static final Number ONE = Number.from("1");
    static final Number ZERO = Number.from("0");

    private final int value;

    private Number(int value) {
        this.value = value;
    }

    static Number from(String string) {
        return new Number(parseInt(string));
    }

    private static int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("number value(%s) must be number format", string), e);
        }
    }

    int value() {
        return value;
    }

    Number plus(Number target) {
        return new Number(value + target.value);
    }

    Number minus(Number target) {
        return new Number(value - target.value);
    }

    Number multiply(Number target) {
        return new Number(value * target.value);
    }

    Number divide(Number target) {
        if (Number.ZERO.equals(target)) {
            throw new IllegalArgumentException("cannot be divided by zero");
        }
        return new Number(value / target.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                '}';
    }
}
