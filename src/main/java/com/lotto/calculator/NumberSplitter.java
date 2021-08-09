package com.lotto.calculator;

import java.util.Arrays;

public class NumberSplitter {
    private static final String DEFAULT_SEPERATOR_REGEX = "\\,|\\:";

    public static int[] split(String input) {
        return Arrays.stream(input.split(DEFAULT_SEPERATOR_REGEX))
                .mapToInt(Integer::valueOf).toArray();
    }
}
