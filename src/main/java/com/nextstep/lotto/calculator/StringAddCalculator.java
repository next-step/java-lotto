package com.nextstep.lotto.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String source) {
        if (source == null || "".equals(source)) {
            return ZERO;
        }

        CalculatorItem item = parse(source);
        return addItem(item);
    }

    private static CalculatorItem parse(String source) {
        if(!source.matches(CUSTOM_REGEX)) {
            return new CalculatorItem(source);
        }
        return parseCalculatorItem(source);
    }

    private static CalculatorItem parseCalculatorItem(String source) {
        Pattern pattern = Pattern.compile(CUSTOM_REGEX);
        Matcher matcher = pattern.matcher(source);
        CalculatorItem item = null;
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String numbers = matcher.group(2);
            item = new CalculatorItem(numbers, delimiter);
        }
        return item;
    }

    private static int addItem(CalculatorItem item) {
        String source = item.getNumbers();
        String delimiter = item.getDelimiter();
        String[] numbers = source.split(delimiter);
        int result = 0;
        for (String number : numbers) {
            result += parseInt(number);
        }
        return result;
    }

    private static int parseInt(String number) {
        return Integer.parseInt(number);
    }
}
