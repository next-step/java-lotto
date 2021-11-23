package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static lotto.utils.Validator.checkNotNull;

public class IntegerParser {

    private static final String DELIMITER = ",";

    private IntegerParser() {
    }

    public static List<Integer> listOf(String string) {
        checkNotNull(string);
        return stream(string.split(DELIMITER))
                .map(String::trim)
                .map(IntegerParser::parseInt)
                .collect(Collectors.toList());
    }

    public static int parseInt(String stringNum) {
        try {
            return Integer.parseInt(stringNum.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 가능합니다.");
        }
    }
}
