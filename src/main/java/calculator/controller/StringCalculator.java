package calculator.controller;


import calculator.entity.CalculateExpression;
import calculator.entity.Expressions;

import java.util.function.UnaryOperator;

public class StringCalculator {
    private static final String DEFAULT_SPLIT_DELIMITER = " ";
    private static final int INIT_RESULT_INDEX = 0;
    private static final UnaryOperator<Integer> NUMBER_SEARCH = expressionIndex -> expressionIndex + 1;

    private final Expressions expressions = new Expressions();

    private int result;

    public StringCalculator(String text) {
        validate(text);

        String[] numberOrExpression = split(text);
        this.result = toInt(numberOrExpression[INIT_RESULT_INDEX]);

        calculate(numberOrExpression);
    }

    private void validate(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("빈 값 검증");
        }
    }

    private void calculate(String[] values) {
        for (int expressionsIndex = 1; expressionsIndex < values.length; expressionsIndex += 2) {
            CalculateExpression expression = expressions.findExpression(values[expressionsIndex]);
            int number = toInt(values[NUMBER_SEARCH.apply(expressionsIndex)]);
            this.result = expression.result(this.result, number);
        }
    }

    public int result() {
        return this.result;
    }

    private int toInt(String value) {
        return Integer.parseInt(value);
    }

    private String[] split(String text) {
        return text.split(DEFAULT_SPLIT_DELIMITER);
    }
}
