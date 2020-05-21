package stringcalculator.domain;

import java.util.Objects;

public class Number {
    private int value;

    private Number(int value) {
        validateValue(value);
        this.value = value;
    }

    public Number(String inputValue) {
        this(Integer.parseInt(inputValue));
    }

    private void validateValue(int value) {
        if (value < 0) {
            throw new RuntimeException();
        }
    }

    public Number add(Number inputNumber) {
        return new Number(this.value + inputNumber.getValue());
    }

    public int getValue() {
        return value;
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
    public int hashCode() {
        return Objects.hash(value);
    }
}
