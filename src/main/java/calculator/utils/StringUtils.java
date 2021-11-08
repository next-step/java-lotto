package calculator.utils;

public final class StringUtils {
    private StringUtils() {
    }

    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }

    public static boolean isNumeric(String text) {
        if (text == null) {
            return false;
        }
        int textSize = text.length();
        for (int i = 0; i < textSize; i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
