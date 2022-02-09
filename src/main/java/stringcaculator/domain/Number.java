package stringcaculator.domain;

public class Number {

    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "[ERROR] %s는 숫자가 아닙니다";
    private static final String NEGATIVE_EXCEPTION_MESSAGE = "[ERROR] 0 이상의 수만 들어올 수 있습니다";

    private final int number;

    public Number(String number) {
        this.number = parse(number);
    }

    public int value() {
        return number;
    }

    private int parse(String number) {
        int parsedNumber = parseNumber(number);
        validatePositive(parsedNumber);
        return parsedNumber;
    }

    private void validatePositive(int number) {
        if (isNegative(number)) {
            throw new IllegalArgumentException(NEGATIVE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNegative(int number) {
        return number < 0;
    }

    private int parseNumber(String splitNumber) {
        int number;
        try {
            number = Integer.parseInt(splitNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                String.format(NOT_NUMBER_EXCEPTION_MESSAGE, splitNumber));
        }
        return number;
    }
}
