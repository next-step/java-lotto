package study.step4.util;

public class StringUtil {
    private static final String DEFAULT_SPLIT_DELIMITER = ",";

    public static String[] split(String input) {
        return split(DEFAULT_SPLIT_DELIMITER, input);
    }

    public static String[] split(String delimiter, String input) {
        if (isIllegalArgument(input)) {
            throw new IllegalArgumentException();
        }
        return input.replace(" ", "")
            .split(delimiter);
    }

    private static boolean isIllegalArgument(String input) {
        return input == null || "".equals(input.trim());
    }
}
