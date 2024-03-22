package utils;

public class StringUtils {
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";

    private StringUtils() {}

    public static String removeSpace(String input) {
        assertStringNotBlank(input);
        return input.replaceAll(SPACE, EMPTY_STRING);
    }

    private static void assertStringNotBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("문자열을 입력하세요.");
        }
    }
}
