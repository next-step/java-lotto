package com.lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final String SEPARATOR = ",";

    public static List<Integer> parseNumbers(String input) {
        String[] inputNumbers = input.split(SEPARATOR);

        return Arrays.stream(inputNumbers)
                .map((str) -> convert(str))
                .collect(Collectors.toList());
    }

    public static Integer convert(String str) {
        try {
            return Integer.parseInt(str.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력 되었습니다. , 입력된 값 : " + str);
        }
    }
}
