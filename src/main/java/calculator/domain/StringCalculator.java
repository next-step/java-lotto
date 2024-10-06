package calculator.domain;

import calculator.domain.cal.CalculableType;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StringCalculator {

    private static final String OPERATOR_REGEX = "[+\\-*/]";
    private static final String DELIMITER = " ";

    public int splitAndCalculate(String expression) {
        validateEmpty(expression);
        String[] splitExpressions = expression.split(DELIMITER);
        return calculate(splitExpressions);
    }

    private void validateEmpty(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("주어진 식이 빈 문자입니다. [" + expression + "]");
        }
    }

    private int calculate(String[] splitExpressions) {
        Queue<String> expressions = new LinkedList<>(List.of(splitExpressions));

        int result = parseInt(expressions.poll());
        while (!expressions.isEmpty()) {
            result = calculate(expressions, result);
        }
        return result;
    }

    private int calculate(Queue<String> expressions, int preResult) {
        String expression = expressions.poll();
        if (expression != null && expression.matches(OPERATOR_REGEX)) {
            return CalculableType.getCalculable(expression).calculate(preResult, parseInt(expressions.poll()));
        }
        throw new IllegalArgumentException("유효하지 않은 문자입니다. [" + expression + "]");
    }

    private static int parseInt(String operand) {
        return Integer.parseInt(operand);
    }
}
