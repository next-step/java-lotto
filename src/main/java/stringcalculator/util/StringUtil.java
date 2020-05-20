package stringcalculator.util;

public class StringUtil {

    private StringUtil() {
    }

    public static boolean isEmpty(final String string) {
        return (string == null || string.isEmpty());
    }

    public static int toInt(final String number) {
        return Integer.parseInt(number);
    }
}
