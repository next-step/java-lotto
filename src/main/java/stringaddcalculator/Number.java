package stringaddcalculator;

import java.util.Objects;

public class Number {

    private static final int VALID_MIN_NUMBER = 0;
    private static final int INIT_NUMBER = 0;

    private final int value;

    public Number(int input) {
        validateInputOrThrow(input);
        value = input;
    }

    private void validateInputOrThrow(int input) {
        if (input < VALID_MIN_NUMBER) {
            throw new RuntimeException("input number must be positive");
        }
    }

    public Number(String input) {
        this(Integer.parseInt(input));
    }

    public static Number init() {
        return new Number(INIT_NUMBER);
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
