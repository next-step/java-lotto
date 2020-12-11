package com.jaenyeong.mission01.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {
    private static final int NONE = 0;
    private static final String NUMBERS_SEPARATORS = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\\n(.*)";
    private static final String TEXT_ERR_INVALID_STRING = "[error] : An invalid string was entered.";
    public static final int EXPRESSION_GROUP = 2;
    public static final int SEPARATOR_GROUP = 1;

    public List<Integer> parseToNumbers(String exp) {
        if (Validator.isBlank(exp)) {
            return returnNone();
        }

        exp = exp.trim();
        if (Validator.isOneDigit(exp)) {
            return splitWhenNumberIsNaturalNumber(exp);
        }

        return splitWhenNumberIsNaturalNumberList(exp);
    }

    private List<Integer> returnNone() {
        final List<Integer> numbers = new ArrayList<>();
        numbers.add(NONE);
        return numbers;
    }

    protected List<Integer> splitWhenNumberIsNaturalNumber(final String exp) {
        if (Validator.isNaturalNumber(exp)) {
            final List<Integer> numbers = new ArrayList<>();
            numbers.add(parseInt(exp));
            return numbers;
        }

        throw new RuntimeException(TEXT_ERR_INVALID_STRING);
    }

    private int parseInt(final String exp) {
        return Integer.parseInt(exp);
    }

    protected List<Integer> splitWhenNumberIsNaturalNumberList(final String exp) {
        final Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(exp);

        if (matcher.find()) {
            return Arrays.stream(matcher.group(EXPRESSION_GROUP)
                .split(matcher.group(SEPARATOR_GROUP)))
                .map(this::parseInt)
                .collect(Collectors.toList());
        }

        final List<String> expList = Arrays.stream(exp.split(NUMBERS_SEPARATORS))
            .collect(Collectors.toList());

        return expList.stream()
            .filter(Validator::isNaturalNumber)
            .map(this::parseInt)
            .collect(Collectors.toList());
    }
}
