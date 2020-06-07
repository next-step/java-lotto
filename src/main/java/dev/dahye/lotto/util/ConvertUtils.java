package dev.dahye.lotto.util;

import java.util.ArrayList;
import java.util.List;

public class ConvertUtils {
    private static final String WINNERS_DELIMITER = ",";

    public static List<Integer> convertStringToIntegerList(String input) {
        validateWinnersNullOrEmpty(input);

        String[] strings = input.split(WINNERS_DELIMITER);
        List<Integer> ints = new ArrayList<>();

        for (String string : strings) {
            ints.add(convertStringToInteger(string.trim()));
        }

        return ints;
    }

    private static void validateWinnersNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("올바르지 않은 입력 값입니다.");
        }
    }

    private static int convertStringToInteger(String string) {
        try {
            return Integer.parseInt(string.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 숫자만 입력 가능합니다.");
        }
    }
}
