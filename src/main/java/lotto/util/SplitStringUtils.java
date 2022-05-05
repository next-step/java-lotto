package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SplitStringUtils {
    private SplitStringUtils() {
    }

    public static List<String> split(String text, String delimiter) {
        if (isBlank(text) || isBlank(delimiter)) {
            throw new IllegalArgumentException("입력 문자열과 구분자는 비어있을 수 없습니다.");
        }
        return Stream.of(text.split(delimiter)).map(String::trim).collect(Collectors.toList());
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
}
