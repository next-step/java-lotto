package calculator.model;

import calculator.exception.DividedNumberException;

import java.util.Objects;

public class Number {

    private static final Number ZERO = new Number(0);

    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public Number add(Number otherNumber) {
        return new Number(this.value + otherNumber.value);
    }

    public Number subtract(Number otherNumber) {
        return new Number(this.value - otherNumber.value);
    }


    public Number multiply(Number otherNumber) {
        return new Number(this.value * otherNumber.value);
    }

    public Number divide(Number otherNumber) {
        if (otherNumber.isZero()) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        int dividedValue = this.value / otherNumber.value;

        if (this.value % otherNumber.value != 0) {
            throw new DividedNumberException();
        }

        return new Number(dividedValue);
    }

    private boolean isZero() {
        return this.equals(ZERO);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
