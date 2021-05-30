package lotto.utils;

public class ValidationUtil {
    public static boolean isIntegerNumber(String numberText) {
        try {
            Integer.parseInt(numberText);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static boolean isLongNumber(String numberText) {
        try {
            Long.parseLong(numberText);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
