package string_add_calculator.model;

import java.util.Objects;

public class Number {

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number of(final int number) {
        return new Number(number);
    }

    public static Number of(final String numberString) {
        int number = Integer.parseInt(numberString);

        if (number < 0) {
            throw new RuntimeException("number must be greater than zero.");
        }

        return new Number(number);
    }

    public Number add(Number another) {
        return Number.of(number + another.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return Objects.equals(number, number1.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
