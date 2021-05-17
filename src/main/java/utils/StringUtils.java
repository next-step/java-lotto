package utils;

public class StringUtils {

    private static final String SEPARATOR_STRING_COMMA = ",";

    public static String[] split(String input) {
        return input.split(SEPARATOR_STRING_COMMA);
    }
}
