package me.daeho.calculator;

import me.daeho.utils.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringAddCalculator {
    private static final String DEFAULT_REGEX = ",|:";
    private static final String CUSTOM_REGEX =  "//(.)\n(.*)";

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
        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(data);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return sum(m.group(2).split(customDelimiter));
        }

        return sum(parsingDefault(data));
    }

    private static int sum(String[] parsedData) {
        return Arrays.stream(parsedData)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}
