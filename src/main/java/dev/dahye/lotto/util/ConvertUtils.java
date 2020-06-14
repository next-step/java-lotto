package dev.dahye.lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ConvertUtils {
    private static final String WINNERS_DELIMITER = ",";

    private ConvertUtils() {
    }

    public static List<Integer> convertStringToIntegerList(String input) {
        validateWinnersNullOrEmpty(input);

        String[] strings = input.split(WINNERS_DELIMITER);

        return Arrays.stream(strings)
                .map(String::trim)
                .map(ConvertUtils::convertStringToInteger)
                .collect(Collectors.toList());
    }

    private static void validateWinnersNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("올바르지 않은 입력 값입니다.");
        }
    }

    private static int convertStringToInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 숫자만 입력 가능합니다.");
        }
    }
}
