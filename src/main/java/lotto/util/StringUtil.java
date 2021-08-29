package lotto.util;

import java.util.Objects;

public class StringUtil {
    private static final String DELIMITER = ",";

    public static String[] split(String values) {
        checkNullOrEmpty(values);
        return values.split(DELIMITER);
    }

    private static void checkNullOrEmpty(String values) {
        if (Objects.isNull(values) || values.isEmpty()) {
            throw new IllegalArgumentException("split 대상이 null이거나 empty일 수 없습니다.");
        }
    }
}