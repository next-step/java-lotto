package calculator;

import calculator.delimiter.Delimiter;

import java.util.List;
import java.util.Objects;

public class Calculator {
    private static final int ZERO = 0;

    public int calculate(String expression, List<Delimiter> delimiters) {
        if (Objects.isNull(expression) || expression.isEmpty()) {
            return ZERO;
        }

        List<String> splitResult = Splitter.split(expression, delimiters);
        this.validateSplitExpressions(splitResult);

        return splitResult.stream()
                .map(splitExpression -> Integer.parseInt(splitExpression))
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void validateSplitExpressions(List<String> splitExpressions) {
        for (String expression : splitExpressions) {
            this.validateNotValidString(expression);
        }
    }

    private void validateNotValidString(String expression) {
        Integer convertNumber = null;
        try {
            convertNumber = Integer.parseInt(expression);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("invalid delimiter : %s", expression));
        }

        if (convertNumber < 0) {
            throw new IllegalArgumentException(String.format("not permit negative number : %s", convertNumber));
        }
    }
}
