package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int calculate(String expression) {
        validateExpression(expression);
        return operate(parseExpression(expression));
    }

    private static void validateExpression(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("계산식이 잘못되었습니다.");
        }
    }

    private static List<String> parseExpression(String expression) {
        return Arrays.stream(expression.split(" "))
                .collect(Collectors.toList());
    }

    private static int operate(List<String> expressionElements) {
        int firstOperand = Integer.parseInt(expressionElements.get(0));
        int index = 1;

        while (index < expressionElements.size()) {
            String operator = expressionElements.get(index++);
            int secondOperand = Integer.parseInt(expressionElements.get(index++));
            firstOperand = Operator.operate(firstOperand, operator, secondOperand);
        }

        return firstOperand;
    }
}
