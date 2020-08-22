package calculator.util;

public class ValidationUtil {
    private ValidationUtil() {
    }

    public static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
