package calculator.domain.calculator;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(int number) {
        validateNegative(number);
        this.number = number;
    }

    public Number(String input) {
        this(Integer.parseInt(input));
    }

    private void validateNegative(int number) {
        if (number < 0) {
            throw new NegativeInputException();
        }
    }

    public int getNumber() {
        return number;
    }

    public static Number add(Number number1, Number number2) {
        return new Number(number1.getNumber() + number2.getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
