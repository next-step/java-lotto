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

        Splitter item = parse(source);
        return addNumbers(item);
    }

    private static Splitter parse(String source) {
        Matcher matcher = PATTERN.matcher(source);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return new Splitter(numbers, delimiter);
        }
        return new Splitter(source);
    }

    private static int addNumbers(Splitter splitter) {
        String[] numbers = splitter.split();
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
