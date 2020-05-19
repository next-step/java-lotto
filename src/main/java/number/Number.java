package number;

import util.StringUtil;

public class Number {

    private static final int ZERO = 0;

    private int value;

    private Number() {
    }

    private Number(final String number) {
        this.value = StringUtil.toInt(number);
        validateNegativeNumber(this.value);
    }

    public static Number of(final String number) {
        return new Number(number);
    }

    private void validateNegativeNumber(final int number) {
        if (isNegative(number)) {
            throw new RuntimeException();
        }
    }

    private boolean isNegative(final int number) {
        return number < ZERO;
    }
}
