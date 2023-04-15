package calculator.util;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    private StringUtils() {
    }

    public static List<String> split(String input) {
        return Arrays.asList(input.split(" "));
    }

    public static int parse(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        return parseInt(input);
    }

    public static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수만 입력 가능합니다.");
        }
    }
}
