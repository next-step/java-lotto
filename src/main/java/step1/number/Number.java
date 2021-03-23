package step1.number;

import step1.exception.NegativeNumberInputException;
import step1.exception.StringNumberFormatException;

public final class Number {

    private final int number;
    private final int ZERO = 0;

    public Number(String number) {
        this(convertStringToInt(number));
    }

    public Number(int number) {
        if(isNegative(number)) {
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

}
