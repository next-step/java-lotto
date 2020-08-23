package study;

import java.util.Objects;

public class StringUtils {

    public static boolean isBlank(String str) {
        return Objects.isNull(str) || str.trim().isEmpty();
    }
}
