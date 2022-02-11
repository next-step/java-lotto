package lotto.utils;

public class Parser {

    private static final String NOT_A_NUMBER_EXCEPTION_FORMAT = "숫자만 입력 가능합니다. (Input: %s)";

    private Parser() {}

    public static int parseInt(String value) {
        int number;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(NOT_A_NUMBER_EXCEPTION_FORMAT, value));
        }
        return number;
    }
}
