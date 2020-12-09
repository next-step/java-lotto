package com.nextstep.lotto.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_REGEX);

    public static int sum(String source) {
        if (source == null || "".equals(source)) {
            return ZERO;
        }

        CalculatorVo item = parse(source);
        return addItem(item);
    }

    private static CalculatorVo parse(String source) {
        if(!source.matches(CUSTOM_REGEX)) {
            return new CalculatorVo(source);
        }
        return parseCalculatorItem(source);
    }

    private static CalculatorVo parseCalculatorItem(String source) {
        Matcher matcher = PATTERN.matcher(source);
        CalculatorVo item = null;
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String numbers = matcher.group(2);
            item = new CalculatorVo(numbers, delimiter);
        }
        return item;
    }

    private static int addItem(CalculatorVo item) {
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
        int result = Integer.parseInt(number);
        if (result < 0) {
            throw new RuntimeException(result + " is negative value");
        }
        return result;
    }
}
