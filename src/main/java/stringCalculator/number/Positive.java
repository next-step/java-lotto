package stringCalculator.number;

import stringCalculator.common.ErrorMessage;

public class Positive {
    private static final int MIN_VALUE = 0;
    private final int value;

    public Positive(String value) {
        this.value = toInteger(value);
    }

    public int getValue() {
        return value;
    }

    private int toInteger(String value) {
        int result = Integer.parseInt(value);
        checkNegative(result);
        return result;
    }

    private void checkNegative(int value) {
        if (value < MIN_VALUE) {
            ErrorMessage.NEGATIVE_VALUE.throwError();
        }
    }
}