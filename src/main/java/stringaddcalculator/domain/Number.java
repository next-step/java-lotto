package stringaddcalculator.domain;

import static stringaddcalculator.StringAddCalculator.ZERO;

public class Number {
    private static final String NEGATIVE_COMMENT = "음수가 입력될 수 없습니다.";
    private static final String NUMBER_EXCEPTION_COMMENT = "입력된 문자열이 숫자가  아닙니다";

    private int number;

    public Number(String number) {
        this.number = parseNumber(number);
        validateNumber();
    }

    protected int value() {
        return this.number;
    }


    private int parseNumber(String number) {
        if (isNotNumeric(number)) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION_COMMENT);
        }
        return Integer.parseInt(number);

    }

    private boolean isNotNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private void validateNumber() {
        if (numberIsNegative()) {
            throw new RuntimeException(NEGATIVE_COMMENT);
        }
    }

    private boolean numberIsNegative() {
        return number <= ZERO;
    }

}
