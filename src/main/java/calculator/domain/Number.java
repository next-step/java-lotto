package calculator.domain;

public class Number {

    private final int value;

    private Number(final int value) {
        validatePositiveNum(value);
        this.value = value;
    }

    public static Number from(final String number) {
        validateNumberFormat(number);
        return new Number(Integer.parseInt(number));
    }

    public static Number from(final int number) {
        return new Number(number);
    }

    private static void validateNumberFormat(final String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 포맷이 아닙니다.");
        }
    }

    public Number add(Number operand) {
        return new Number(value + operand.getValue());
    }

    private void validatePositiveNum(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("숫자가 음수입니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
