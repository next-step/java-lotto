package stringCalculator;

import java.util.Map;
import java.util.function.BiFunction;

public class StringCalculator {
    private static final Map<Character, BiFunction<Integer, Integer, Integer>> OPERATIONS = Map.of(
            '+', (a, b) -> a + b,
            '-', (a, b) -> a - b,
            '*', (a, b) -> a * b,
            '/', (a, b) -> {
                validateNonZero(b);
                return a / b;
            }
    );
    public static final String DELIMITER = " ";
    public static final int INITIAL_INDEX = 0;
    public static final int FIRST_OPERATOR_INDEX = 1;
    public static final int OPERATOR_INCREMENT = 2;

    public static int splitAndCalculate(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        String[] tokens = expression.split(DELIMITER);
        int result = Integer.parseInt(tokens[INITIAL_INDEX]);

        for (int i = FIRST_OPERATOR_INDEX; i < tokens.length; i += OPERATOR_INCREMENT) {
            char operation = tokens[i].charAt(0);
            int nextNumber = Integer.parseInt(tokens[i + 1]);

            result = applyOperation(operation, result, nextNumber);
        }
        return result;
    }

    private static int applyOperation(char operation, int a, int b) {
        BiFunction<Integer, Integer, Integer> operationFunction = OPERATIONS.get(operation);
        if (operationFunction == null) {
            throw new UnsupportedOperationException("Unsupported operation: " + operation);
        }
        return operationFunction.apply(a, b);
    }

    private static void validateNonZero(int b) {
        if (b == 0) {
            throw new UnsupportedOperationException("Cannot divide by zero");
        }
    }
}
