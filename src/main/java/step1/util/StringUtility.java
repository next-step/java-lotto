package step1.util;

public class StringUtility {
    private final static String EXCEPTION_MESSAGE_BLANK_INPUT = "입력값이 빈 값이거나 공백으로만 이뤄졌습니다.";

    public static void validateString(String input) {
        if (blankString(input)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_BLANK_INPUT);
        }
    }

    private static boolean blankString(String input) {
        return input.isBlank();
    }
}
