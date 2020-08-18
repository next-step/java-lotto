package utils;

public class StringUtils {
    public static boolean isBlank(String input) {
        return input == null || input.trim().equals("");
    }

    public static int toNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 제대로 입력해주세요.");
        }
    }
}
