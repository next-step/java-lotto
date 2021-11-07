package utils;

public final class StringUtils {
    private StringUtils() {

    }

    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }
}
