package com.jaeyeonling.calculate;

import com.jaeyeonling.calculate.utils.StringUtils;

import java.util.Arrays;

class Expression {

    private static final String DEFAULT_SEPARATOR_REGEX = ",|:";
    private static final Separator<String> DEFAULT_SEPARATOR = new StringSplitSeparator(DEFAULT_SEPARATOR_REGEX);

    private static final String CUSTOM_PREFIX = "//";
    private static final int SEPARATOR_INDEX = 0;
    private static final int VALUE_INDEX = 1;

    private final String expression;

    Expression(final String expression) {
        this.expression = expression;
    }

    boolean isInvalid() {
        return StringUtils.isNullOrBlank(expression);
    }

    int execute() {
        if (isNotCustom()) {
            return execute(expression);
        }

        final Separator<String> separator = new StringSplitSeparator(getSeparatorPart());
        final CalculateValue value = new CalculateValue(getValuePart());

        return execute(separator, value);
    }

    private boolean isNotCustom() {
        return !expression.contains(StringUtils.NEW_LINE);
    }

    private String[] splitExpression() {
        return expression.split(StringUtils.NEW_LINE);
    }

    private String getSeparatorPart() {
        final String separatorPart = splitExpression()[SEPARATOR_INDEX];
        return separatorPart.substring(CUSTOM_PREFIX.length());
    }

    private String getValuePart() {
        return splitExpression()[VALUE_INDEX];
    }

    private static int execute(final String value) {
        return execute(DEFAULT_SEPARATOR, new CalculateValue(value));
    }

    private static int execute(final Separator<String> separator,
                               final CalculateValue value) {
        return Arrays.stream(value.split(separator))
                .mapToInt(Expression::parseInt)
                .sum();
    }

    private static int parseInt(final String s) {
        final int parsedValue = Integer.parseInt(s);
        if (parsedValue < 0) {
            throw new IllegalArgumentException();
        }

        return parsedValue;
    }
}
