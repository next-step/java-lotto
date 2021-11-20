package addcalculator.domain;

import addcalculator.exception.NotNumberException;

import java.util.Objects;

public class Number {

    private final int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number of(String stringNumber) {
        validateIsDigit(stringNumber);
        return new Number(Integer.parseInt(stringNumber));
    }

    private static void validateIsDigit(String stringNumber) {
        boolean isDigit = stringNumber.chars()
                .allMatch(Character::isDigit);
        if (!isDigit) {
            throw new NotNumberException();
        }
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
