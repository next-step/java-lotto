package com.jaenyeong.mission01.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Parser {
    private static final int NONE = 0;
    private static final String DEFAULT_SEPARATORS = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final Pattern PATTERN_COMPILE_BY_CUSTOM = Pattern.compile(CUSTOM_SEPARATOR);
    private static final String TEXT_ERR_INVALID_STRING = "[error] : An invalid string was entered.";
    public static final int EXPRESSION_GROUP = 2;
    public static final int SEPARATOR_GROUP = 1;

    private Parser() {
    }

    public static List<Integer> parseToNumbers(String expression) {
        if (Validator.isBlank(expression)) {
            return returnNone();
        }

        return splitWhenNumberIsNaturalNumberList(expression);
    }

    private static List<Integer> returnNone() {
        final List<Integer> numbers = new ArrayList<>();
        numbers.add(NONE);
        return numbers;
    }

    protected static List<Integer> splitWhenNumberIsNaturalNumberList(final String expression) {
        final Matcher matcher = PATTERN_COMPILE_BY_CUSTOM.matcher(expression);

        if (matcher.find()) {
            return Arrays.stream(matcher.group(EXPRESSION_GROUP)
                .split(matcher.group(SEPARATOR_GROUP)))
                .map(Parser::parseToIntOnlyNaturalNumber)
                .collect(Collectors.toList());
        }

        final List<String> expressionList = Arrays.stream(expression.split(DEFAULT_SEPARATORS))
            .collect(Collectors.toList());

        return expressionList.stream()
            .map(Parser::parseToIntOnlyNaturalNumber)
            .collect(Collectors.toList());
    }

    private static int parseToIntOnlyNaturalNumber(final String expression) {
        if (Validator.isNaturalNumber(expression)) {
            return parseInt(expression);
        }

        throw new RuntimeException(TEXT_ERR_INVALID_STRING);
    }
}
