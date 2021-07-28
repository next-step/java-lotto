package calculator;

import calculator.exception.EmptyNumberException;
import calculator.exception.NegativeNumberException;
import calculator.exception.NonNumericNumberException;

public class Number {

    private static final int ZERO = 0;

    private final int number;

    public Number(String number) {
        number = number.trim();
        validateNumber(number);
        this.number = toInt(number);
    }

    private void validateNumber(String number) {
        validateNumberIsEmpty(number);
        validateNumberIsNumeric(number);
        validateNumberIsNegative(number);
    }

    private void validateNumberIsNegative(String number) {
        if (isNegative(number)) {
            throw new NegativeNumberException(number);
        }
    }

    private void validateNumberIsNumeric(String number) {
        if (!isNumeric(number)) {
            throw new NonNumericNumberException(number);
        }
    }

    private void validateNumberIsEmpty(String number) {
        if (isEmpty(number)) {
            throw new EmptyNumberException(number);
        }
    }

    private boolean isEmpty(String number) {
        return number.isEmpty();
    }

    private boolean isNumeric(String number) {
        try {
            toInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isNegative(String number) {
        return toInt(number) < ZERO;
    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }

    public int intValue() {
        return number;
    }
}
