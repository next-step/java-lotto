package calculator.util;

public class StringUtil {

    public static boolean isEmpty(String input) {
        if (input == null || input.length() == 0) {
            return true;
        }

        String trimmed = input.trim();
        if (trimmed.length() == 0) {
            return true;
        }

        return false;
    }
}
