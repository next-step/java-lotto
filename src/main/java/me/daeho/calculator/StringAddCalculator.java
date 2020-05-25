package me.daeho.calculator;

import me.daeho.utils.IntegerUtils;

import java.util.Arrays;


public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (IntegerUtils.isEmpty(input))
            return 0;

        return sum(StringAddParser.parsing(input));
    }

    private static int sum(String[] parsedData) {
        return Arrays.stream(parsedData)
                .map(StringAddCalculator::textToNumber)
                .reduce(0, Integer::sum);
    }

    private static int textToNumber(String text) {
        return Integer.parseUnsignedInt(text);
    }
}
