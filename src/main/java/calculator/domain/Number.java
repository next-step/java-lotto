package calculator.domain;

import java.util.Objects;

public class Number {
    public static final Number ZERO = new Number(0);

    private final int value;

    public Number(String number) {
        final int integerNumber = Integer.parseInt(number);
        if (integerNumber < 0) {
            throw new RuntimeException();
        }
        this.value = integerNumber;
    }

    private Number(int number) {
        this.value = number;
    }

    public Number add(final Number number) {
        return new Number(this.value + number.value);
    }

    public int getNumber() {
        return value;
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
