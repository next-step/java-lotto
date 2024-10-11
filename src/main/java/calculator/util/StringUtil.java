package calculator.util;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class StringUtil {

    private StringUtil() {
        throw new IllegalStateException("유틸리티 클래스의 인스턴스를 생성할 수 없습니다.");
    }

    public static boolean isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        String trimmed = input.trim();

        return trimmed.isEmpty();
    }

    public static boolean isEmpty(String[] array) {
        if (array == null || array.length == 0) {
            return true;
        }

        return Arrays.stream(array)
                .noneMatch(Objects::nonNull);
    }

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
