package calculator;

import java.util.OptionalInt;

public class Calculrator {

    public static int calculate(String input) {
        validEmptyInput(input);

        String[] splitExpressions = input.split(" ");

        int result = 0;
        Operator currentOperator = Operator.NONE;

        for (String expression : splitExpressions) {
            OptionalInt numberOrEmpty = getNumberOrEmpty(expression);

            if (numberOrEmpty.isEmpty()) {
                currentOperator = Operator.findOperationByValue(expression);
                continue;
            }

            result = calculate(numberOrEmpty.getAsInt(), currentOperator, result);
        }

        return result;
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

    private static int calculate(int expression, Operator currentOperator, int result) {
        if (currentOperator == Operator.MINUS) {
            result -= expression;
            return result;
        }

        if (currentOperator == Operator.SQUARE) {
            result *= expression;
            return result;
        }

        if (currentOperator == Operator.DIVIDE) {
            result /= expression;
            return result;
        }

        result += expression;
        return result;
    }
}
