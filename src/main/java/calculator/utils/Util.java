package calculator.utils;

import java.util.Objects;

public final class Util {
    public static boolean isNullOrEmpty(String userInput) {
        return Objects.isNull(userInput) || userInput.isEmpty();
    }
}
