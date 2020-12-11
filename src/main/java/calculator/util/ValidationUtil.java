package calculator.util;

import java.util.Objects;

public class ValidationUtil {

    private ValidationUtil() {
    }

    public static boolean isBlank(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }
}
