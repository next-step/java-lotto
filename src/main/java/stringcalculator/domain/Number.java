package stringcalculator.domain;

import stringcalculator.exception.DividedByZeroException;

import java.util.Objects;

public class Number {

    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Number add(Number followingNumber) {
        return new Number(this.value + followingNumber.value);
    }

    public Number minus(Number followingNumber) {
        return new Number(this.value - followingNumber.value);
    }

    public Number multiply(Number followingNumber) {
        return new Number(this.value * followingNumber.value);
    }

    public Number divide(Number followingNumber) {
        if (isZero(followingNumber)) {
            throw new DividedByZeroException();
        }
        return new Number(this.value / followingNumber.value);
    }

    private boolean isZero(Number followingNumber) {
        return followingNumber.value == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
