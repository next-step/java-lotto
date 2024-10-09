package calculator.controller;

import calculator.entity.Expression;
import calculator.entity.Expressions;
import calculator.entity.NumberSearch;

public class StringCalculator {
    private static final String DEFAULT_SPLIT_DELIMITER = " ";
    private static final int INIT_RESULT_INDEX = 0;
    private static final NumberSearch NUMBER_SEARCH = index -> index + 1;

    private final Expressions expressions = new Expressions();

    private int result;

    public StringCalculator(String text) {
        validate(text);

        String[] numberOrExpression = split(text);
        this.result = toInt(numberOrExpression[INIT_RESULT_INDEX]);

        calculate(numberOrExpression);
    }

    private void calculate(String[] values) {
        for (int i = 1; i < values.length; i += 2) {
            Expression expression = this.expressions.findExpression(values[i]);
            int number = toInt(values[this.NUMBER_SEARCH.search(i)]);
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

    private void validate(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("빈 값 검증");
        }
    }
}
