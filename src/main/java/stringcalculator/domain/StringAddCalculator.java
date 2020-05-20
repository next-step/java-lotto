package stringcalculator.domain;

import stringcalculator.domain.vo.Number;

import java.util.Objects;

public class StringAddCalculator {
    private static final int DEFAULT_NUMBER = 0;

    public static int calculate(String expression) {
        if (isNullOrEmpty(expression)) {
            return DEFAULT_NUMBER;
        }

        ExpressionNumbers expressionNumbers = new ExpressionNumbers(Splitter.split(expression));

        Number result = expressionNumbers.sumAllNumbers();

        return result.getValue();
    }

    private static boolean isNullOrEmpty(String expression) {
        return Objects.isNull(expression) || expression.isEmpty();
    }
}
