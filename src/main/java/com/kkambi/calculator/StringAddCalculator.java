package com.kkambi.calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern GROUP_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String BASIC_DELIMITER = "[,:]";

    public static int splitAndSum(String formula) {
        if (isInvalidFormula(formula)) {
            return 0;
        }

        String[] tokens = split(formula);
        return sum(tokens);
    }

    private static boolean isInvalidFormula(String formula) {
        if (Objects.isNull(formula)) {
            return true;
        }

        return formula.isEmpty();
    }

    private static String[] split(String formula) {
        Matcher matcher = GROUP_PATTERN.matcher(formula);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return formula.split(BASIC_DELIMITER);
    }

    private static int parseNumber(String token) {
        int number;
        try {
            number = Integer.parseInt(token);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException();
        }

        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(StringAddCalculator::parseNumber)
                .sum();
    }
}
