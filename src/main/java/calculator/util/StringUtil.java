package calculator.util;

public final class StringUtil {
    private StringUtil() {}

    public static boolean isEmpty(final String input) {
        return (input == null) || (input.isEmpty());
    }

    public static boolean isNumeric(final String stringNumber) {
        try {
            Double.parseDouble(stringNumber);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
