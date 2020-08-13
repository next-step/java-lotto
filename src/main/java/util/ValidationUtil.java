package util;

public class ValidationUtil {
    private ValidationUtil() {
    }

    public static Boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
