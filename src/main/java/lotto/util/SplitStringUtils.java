package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SplitStringUtils {
    private static final String COMMA_DELIMITER = ",";

    private SplitStringUtils() {
    }

    public static List<String> split(String text) {
        if (isBlank(text)) {
            throw new IllegalArgumentException("입력 문자열은 비어있을 수 없습니다.");
        }
        return split(text, COMMA_DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static List<String> split(String text, String delimiter) {
        return Stream.of(text.split(delimiter)).map(String::trim).collect(Collectors.toList());
    }
}
