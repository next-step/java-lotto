package calculator.domain;

import calculator.domain.exception.InvalidNumberInputException;
import calculator.domain.exception.UnexpectedCharacterException;
import java.util.Objects;

public class Number {

    private final int value;

    public Number(String number) {
        validateInput(number);
        this.value = Integer.parseInt(number);
    }

    private static void validateInput(String number) {
        if (number == null || number.trim().isEmpty()) {
            throw new InvalidNumberInputException();
        }
        if (!number.matches("\\d+")) {
            throw new UnexpectedCharacterException();
        }
    }

    public Number(int number) {
        this.value = number;
    }

    public int getValue() {
        return value;
    }

    public Number add(Number other) {
        return new Number(this.value + other.getValue());
    }

    public Number subtract(Number other) {
        return new Number(this.value - other.getValue());
    }

    public Number multiplyBy(Number other) {
        return new Number(this.value * other.getValue());
    }

    public Number divideBy(Number other) {
        return new Number(this.value / other.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
