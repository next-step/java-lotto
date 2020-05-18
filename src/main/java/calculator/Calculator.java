package calculator;

import calculator.delimiter.Delimiter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Calculator {
    private static final int ZERO = 0;

    public int calculate(String expression, List<Delimiter> delimiters) {
        if (Objects.isNull(expression) || expression.isEmpty()) {
            return ZERO;
        }

        List<String> splitResult = this.split(expression, delimiters);
        this.validateSplitExpressions(splitResult);

        return splitResult.stream()
                .map(splitExpression -> Integer.parseInt(splitExpression))
                .mapToInt(Integer::intValue)
                .sum();
    }

    private List<String> split(String expression, List<Delimiter> delimiters) {
        List<String> expressions = new ArrayList<>(Arrays.asList(expression));
        for (Delimiter delimiter : delimiters) {
            expressions = delimiter.split(expressions);
        }
        return expressions;
    }

    private void validateSplitExpressions(List<String> splitExpressions) {
        for (String expression : splitExpressions) {
            this.validateNotValidString(expression);
            this.validateNegativeNumber(expression);
        }
    }

    private void validateNotValidString(String expression) {
        try {
            Integer.parseInt(expression);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


    private void validateNegativeNumber(String expression) {
        Integer convertNumber = Integer.parseInt(expression);
        if (convertNumber < 0) {
            throw new IllegalArgumentException();
        }
    }
}
