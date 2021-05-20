package calculator;

import java.util.Objects;

public class Calculator {
    public static int sum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        return 1;
    }

    private static boolean isNullOrEmpty(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }
}

