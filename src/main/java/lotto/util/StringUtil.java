package lotto.util;

public class StringUtil {

    private StringUtil() {
    }

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid string input: " + number);
        }
    }
}