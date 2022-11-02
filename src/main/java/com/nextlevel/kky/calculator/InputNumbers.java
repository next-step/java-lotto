package com.nextlevel.kky.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputNumbers {

    private static final String DELIMITER = " ";

    public static List<String> inputNumbers(String input) {
        validateArgument(input);
        String[] split = input.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(split));
    }

    private static void validateArgument(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("array is empty or not valid element");
        }
    }
}
