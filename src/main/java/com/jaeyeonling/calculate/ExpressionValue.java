package com.jaeyeonling.calculate;

import com.jaeyeonling.calculate.utils.StringUtils;

class ExpressionValue {

    private final String value;

    private ExpressionValue(final String value) {
        this.value = value;
    }

    static ExpressionValue of(final String expression) {
        if (StringUtils.isNullOrBlank(expression)) {
            return new ExpressionValue(expression);
        }
        if (!Expression.isCustomExpression(expression)) {
            return new ExpressionValue(expression);
        }

        final String[] splitExpression = expression.split(Expression.NEW_LINE);
        return new ExpressionValue(splitExpression[1]);

    }

    String[] split(final Separator separator) {
        return separator.split(value);
    }

    boolean isEmpty() {
        return StringUtils.isNullOrBlank(value);
    }
}
