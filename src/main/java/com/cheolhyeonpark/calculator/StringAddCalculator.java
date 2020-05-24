package com.cheolhyeonpark.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.length() < 1) {
            return 0;
        }
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] numbers = matcher.group(2).split(customDelimiter);
            return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
        }
        if (input.contains(",") || input.contains(":")) {
            String[] numbers = input.split("[,|:]");
            return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
        }
        return Integer.parseInt(input);
    }
}
