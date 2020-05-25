package me.daeho.calculator;

import me.daeho.utils.StringUtils;

import java.util.Arrays;


public class StringAddCalculator {
    private static final String DEFAULT_REGEX = ",|:";

    public static int splitAndSum(String input) {
        if (StringUtils.isEmpty(input))
            return 0;

        if (StringUtils.isOnlyNumber(input))
            return Integer.parseInt(input);

        return calculate(input);
    }

    private static String[] parsingDefault(String data) {
        return data.split(DEFAULT_REGEX);
    }

    private static int calculate(String data) {
        return sum(parsingDefault(data));
    }

    private static int sum(String[] parsedData) {
        return Arrays.stream(parsedData)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}
