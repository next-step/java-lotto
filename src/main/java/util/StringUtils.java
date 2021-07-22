package util;

import java.util.Objects;

public class StringUtils {
    public static boolean isEmpty(String inputString) {
        return Objects.isNull(inputString) || inputString.isEmpty();
    }
}
