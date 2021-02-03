package lotto.util;

public class NumberUtils {

    public static Integer returnInteger(String string) throws IllegalArgumentException {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int convertNullToNumber(Integer value) {
        if (value == null) {
            return 0;
        }
        return value;
    }
}
