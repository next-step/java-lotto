package step1.number;

import step1.exception.NegativeNumberInputException;
import step1.exception.StringNumberFormatException;

import java.util.Objects;

public final class PositiveNumber {

    private final int positiveNumber;
    private final int ZERO = 0;

    public PositiveNumber(String positiveNumber) {
        this(convertStringToInt(positiveNumber));
    }

    public PositiveNumber(int positiveNumber) {
        if (isNegative(positiveNumber)) {
            throw new NegativeNumberInputException();
        }
        this.positiveNumber = positiveNumber;
    }

    private static final int convertStringToInt(String positiveNumber) {
        try {
            return Integer.parseInt(positiveNumber);
        } catch (Exception e) {
            throw new StringNumberFormatException();
        }
    }

    private final boolean isNegative(int positiveNumber) {
        return positiveNumber < ZERO;
    }

    public final int getPositiveNumber() {
        return positiveNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber positiveNumber1 = (PositiveNumber) o;
        return positiveNumber == positiveNumber1.positiveNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positiveNumber);
    }
}
