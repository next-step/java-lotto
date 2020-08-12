package calculator.utils;

public class StringUtils {
    public static boolean isNumber(String input) {
        return false;
    }

    public static boolean isBlank(String input) {
        return input == null || input.trim().equals("");
    }

    public static int toNumber(String input) {
        validateNumber(input);

        return Integer.parseInt(input);
    }

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 제대로 입력해주세요.");
        }
    }
}
