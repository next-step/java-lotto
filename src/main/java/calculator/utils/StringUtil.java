package calculator.utils;

import java.util.Objects;

public class StringUtil {
    public static boolean isNullOrEmpty(String inputString) {
        return Objects.isNull(inputString) || inputString.isEmpty();
    }
}
