package com.jaeyeonling.calculate;

import java.util.Arrays;

public class Expression {

    private final ExpressionSeparator separator;
    private final String expression;

    private Expression(final String expression) {
        this.separator = ExpressionSeparator.of(expression);
        this.expression = ExpressionParser.parseExpressionStatement(expression);
    }

    public static Expression of(final String expression) {
        return new Expression(expression);
    }

    public int execute() {
        if (expression.isEmpty()) {
            return 0;
        }

        return Arrays.stream(separator.separate(expression))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
