package calculator;

import java.util.Objects;

public class Number {

    private final static int ZERO_NUMBER = 0;

    private int value;

    private Number(int value) {
        validate(value);
        this.value = value;
    }

    public Number(String inputValue) {
        this.value = Integer.parseInt(inputValue);
    }

    private void validate(int value) {
        if (value < ZERO_NUMBER) {
            throw new RuntimeException();
        }
    }

    public Number add(Number number) {
        return new Number(this.value + number.getValue());
    }

    public int getValue() {
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
