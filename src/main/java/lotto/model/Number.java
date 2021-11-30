package lotto.model;

import java.util.Objects;

public class Number {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final int value;

    public Number(int input) {
        validateInputOrThrow(input);
        value = input;
    }

    private void validateInputOrThrow(int input) {
        if (input < MIN_LOTTO_NUMBER || input > MAX_LOTTO_NUMBER) {
            throw new RuntimeException("input number must be positive");
        }
    }

    public Number(String input) {
        this(Integer.parseInt(input.trim()));
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

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
