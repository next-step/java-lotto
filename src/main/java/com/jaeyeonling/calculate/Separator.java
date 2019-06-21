package com.jaeyeonling.calculate;

import com.jaeyeonling.calculate.utils.StringUtils;

class Separator {

    private static final String DEFAULT_SEPARATOR = ",|:";

    private final String separator;

    private Separator(final String separator) {
        this.separator = separator;
    }

    static Separator of(final String expression) {
        if (StringUtils.isNullOrBlank(expression)) {
            return new Separator(DEFAULT_SEPARATOR);
        }
        if (!Expression.isCustomExpression(expression)) {
            return new Separator(DEFAULT_SEPARATOR);
        }

        final String[] splitExpression = expression.split(Expression.NEW_LINE);

        return new Separator(splitExpression[0].substring(2));
    }

    String[] split(final String expression) {
        return expression.split(separator);
    }
}
