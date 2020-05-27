package com.cheolhyeonpark.calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionGenerator {

    public static final String DEFAULT_DELIMITER = "[,|:]";
    public static final String CUSTOM_DELIMITER_MATCHER = "//(.)\n(.*)";

    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_MATCHER);

    public Expression generate(String input) {
        Matcher matcher = getMatcher(input);
        if (hasCustom(matcher)) {
            return new Expression(getNumbers(matcher.group(2), matcher.group(1)));
        }
        return new Expression(getNumbers(input, DEFAULT_DELIMITER));
    }

    private Matcher getMatcher(String input) {
        return pattern.matcher(input);
    }

    private boolean hasCustom(Matcher matcher) {
        return matcher.find();
    }

    private String[] getNumbers(String input, String delimiter) {
        return input.split(delimiter);
    }
}
