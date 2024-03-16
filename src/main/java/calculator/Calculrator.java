package calculator;

import java.util.LinkedList;
import java.util.OptionalInt;
import java.util.Queue;

public class Calculrator {
    private static final Queue<String> expressionQueue = new LinkedList<>();

    public static int calculate(String input) {
        validEmptyInput(input);

        String[] splitExpressions = input.split(" ");

        int result = 0;
        Operator currentOperator = Operator.NONE;

        for (String expression : splitExpressions) {
            expressionQueue.offer(expression);
        }

        return calculateExpression(result, currentOperator);
    }

    private static int calculateExpression(int result, Operator currentOperator) {
        if(expressionQueue.isEmpty()) {
            return result;
        }

        String polledExpression = expressionQueue.poll();
        OptionalInt numberOrEmpty = getNumberOrEmpty(polledExpression);

        if (numberOrEmpty.isEmpty()) {
            currentOperator = Operator.findOperationByValue(polledExpression);
            return calculateExpression(result, currentOperator);
        }

        result = calculate(numberOrEmpty.getAsInt(), currentOperator, result);

        return calculateExpression(result, currentOperator);
    }

    private static int calculate(int expression, Operator currentOperator, int result) {
        return currentOperator.calculate(result, expression);
    }

    private static void validEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static OptionalInt getNumberOrEmpty(String expression) {
        try {
            return OptionalInt.of(Integer.valueOf(expression));
        } catch (NumberFormatException e) {
            return OptionalInt.empty();
        }
    }
}
