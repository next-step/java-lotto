package util;

public class StringUtils {
    private StringUtils() {
        throw new AssertionError();
    }

    public static boolean isNotBlank(final String str) {
        return !isBlank(str);
    }

    public static boolean isBlank(final String str) {
        if (str == null || (str.length()) == 0) {
            return true;
        }

        return str.chars().allMatch(Character::isWhitespace);
    }
}
