package utils;

public class StringUtils {

    private static final String SEPARATOR_STRING_COMMA = ",";

    public static String[] split(String input) {
        return input.split(SEPARATOR_STRING_COMMA);
    }

    public static String removeParenthesis(String input) {
        return input.substring(1, input.length() - 1);
    }

    public static String getCharAtIndex(String input, int i) {
        return String.valueOf(input.charAt(i));
    }
}
