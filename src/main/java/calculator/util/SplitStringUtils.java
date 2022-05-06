package calculator.util;

import java.util.List;

public class SplitStringUtils {
    private static final String BLANK_DELIMITER = " ";

    private SplitStringUtils() {
    }

    public static List<String> split(String text) {
        if (isBlank(text)) {
            throw new IllegalArgumentException("입력 문자열은 비어있을 수 없습니다.");
        }
        return split(text, BLANK_DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static List<String> split(String text, String delimiter) {
        return List.of(text.split(delimiter));
    }
}
