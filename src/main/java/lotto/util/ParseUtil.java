package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ParseUtil {
    private static final String ILLEGAL_NUMBER_FORMAT_EXCEPTION_MESSAGE = "입력 형식이 올바르지 않습니다.";

    private ParseUtil() {}

    public static int parseToInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    public static List<Integer> parseToIntegers(String inputValue, String delimiterRegex) {
        try {
            return Arrays.stream(inputValue.split(delimiterRegex))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
