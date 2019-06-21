package com.jaeyeonling.calculate;

import java.util.Arrays;

class Expression {

    private static final int ZERO = 0;
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String NEW_LINE = "\n";
    private static final String CUSTOM_PREFIX = "//";

    private final String expression;

    Expression(final String expression) {
        this.expression = expression;
    }

    int execute() {
        if (isInvalid()) {
            return ZERO;
        }

        final String separator = getSeparator();
        final String value = getValue();

        return Arrays.stream(value.split(separator))
                .mapToInt(this::parseInt)
                .sum();
    }

    private String getSeparator() {
        if (isCustom()) {
            final String[] splitExpression = expression.split(NEW_LINE);

            return splitExpression[0].substring(2);
        }

        return DEFAULT_SEPARATOR;
    }

    private String getValue() {
        if (isCustom()) {
            final String[] splitExpression = expression.split(NEW_LINE);

            return splitExpression[1];
        }

        return expression;
    }

    private boolean isCustom() {
        return expression.startsWith(CUSTOM_PREFIX);
    }

    private boolean isInvalid() {
        return expression == null || expression.isBlank();
    }

    private int parseInt(final String s) {
        final int parsedValue = Integer.parseInt(s);
        if (parsedValue < ZERO) {
            throw new IllegalArgumentException();
        }

        return parsedValue;
    }
}
