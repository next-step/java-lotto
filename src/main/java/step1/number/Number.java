package step1.number;

import step1.exception.NegativeNumberInputException;
import step1.exception.StringNumberFormatException;

import java.util.Objects;

public final class Number {

    private final int number;
    private final int ZERO = 0;

    public Number(String number) {
        this(convertStringToInt(number));
    }

    public Number(int number) {
        if (isNegative(number)) {
            throw new NegativeNumberInputException();
        }
        this.number = number;
    }

    private static final int convertStringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new StringNumberFormatException();
        }
    }

    private final boolean isNegative(int number) {
        return number < ZERO;
    }

    public final int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
