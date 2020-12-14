package com.jaenyeong.mission02.lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String SEPARATOR = ", ";

    private Parser() {
    }

    public static List<Integer> parseWinningNumbers(final String input) {
        return Arrays.stream(input.split(SEPARATOR))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
