package lotto.utils;

public class StringUtils {

    private StringUtils() {
    }

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }

    public static String[] split(String value, String delimiter) {
        return value.split(delimiter);
    }

}
