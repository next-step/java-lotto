package calculators.vo;

import calculators.exceptions.NegativeNumberException;
import calculators.exceptions.NonNumericException;

import java.util.Objects;

public class Number {

    private final int value;

    private Number(String input) {
        try {
            this.value = Integer.parseInt(input);
            if (value < 0) {
                throw new NegativeNumberException();
            }
        } catch (NumberFormatException e) {
            throw new NonNumericException();
        }
    }

    public static Number from(String input) {
        return new Number(input);
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
