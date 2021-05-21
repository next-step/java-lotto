package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    public static final String INPUT_NUMBER_ERROR_MESSAGE = "숫자만 입력 가능합니다.";

    public static List<Integer> toIntegerList(String numbers) {
        String removeBlankNumbers = numbers.replace(" ", "");
        return Arrays.stream(removeBlankNumbers.split(","))
                .map(StringUtils::parseInteger)
                .collect(Collectors.toList());
    }

    public static int parseInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR_MESSAGE, e);
        }
    }
}
