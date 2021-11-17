package lotto.utils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class IntegerParser {

    private static final String DELIMITER = ",";

    public static List<Integer> listOf(String string) {
        checkNotNull(string);
        return stream(string.split(DELIMITER))
                .map(String::trim)
                .map(IntegerParser::parseInt)
                .collect(Collectors.toList());
    }

    private static int parseInt(String stringNum) {
        try {
            return Integer.parseInt(stringNum.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 가능합니다.");
        }
    }

    private static void checkNotNull(String string) {
        if (Objects.isNull(string)) {
            throw new IllegalArgumentException("필수 값이 없습니다.");
        }
    }
}
