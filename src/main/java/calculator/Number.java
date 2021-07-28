package calculator;

public class Number {

    public static final String MESSAGE_INVALID_NUMBER = "유효하지 않은 숫자입니다";
    private static final int ZERO = 0;

    private final int number;

    public Number(String number) {
        number = number.trim();
        validateNumber(number);
        this.number = toInt(number);
    }

    private void validateNumber(String number) {
        if (isEmpty(number) || !isNumeric(number) || isNegative(number)) {
            throw new RuntimeException(String.format("%s: %s", MESSAGE_INVALID_NUMBER, number));
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
