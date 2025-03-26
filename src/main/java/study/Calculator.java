package study;

import java.util.Arrays;
import java.util.function.BiFunction;

public class Calculator {
    public static int calculate(String expression) {
        validate(expression);

        var splitExpression = parseExpression(expression);

        return calculate(splitExpression);
    }

    private static int calculate(String[] splitExpression) {
        int result = Integer.parseInt(splitExpression[0]);

        for (int i = 1; i < splitExpression.length; i += 2) {
            var operator = Operation.getOperationFunctionBySymbol(splitExpression[i]);
            int operand = Integer.parseInt(splitExpression[i + 1]);
            result = operator.apply(result, operand);
        }

        return result;
    }

    private static String[] parseExpression(String expression) {
        return expression.split(" ");
    }

    private static void validate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("Invalid expression");
        }
    }

    enum Operation {
        ADDITION("+", Integer::sum),
        SUBTRACTION("-", (a, b) -> a - b),
        MULTIPLICATION("*", (a, b) -> a * b),
        DIVISION("/", (a, b) -> a / b);

        private final String symbol;
        private final BiFunction<Integer, Integer, Integer> operationFunction;

        Operation(String symbol, BiFunction<Integer, Integer, Integer> operationFunction) {
            this.symbol = symbol;
            this.operationFunction = operationFunction;
        }

        static BiFunction<Integer, Integer, Integer> getOperationFunctionBySymbol(String symbol) {
            return Arrays.stream(values())
                    .filter(operation -> operation.symbol.equals(symbol))
                    .findFirst()
                    .map(operation -> operation.operationFunction)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid expression"));
        }
    }
}
