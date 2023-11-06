package calculator.domain;

import java.util.function.BiFunction;

public enum Operation {

    PLUS("+", (number1, number2) -> number1 + number2),
    MINUS("-", (number1, number2) -> number1 - number2),
    MULTIPLICATION("*", (number1, number2) -> number1 * number2),
    DIVISION("/", (number1, number2) -> number1 / number2);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> calculator;

    Operation(String symbol, BiFunction<Integer, Integer, Integer> calculator) {
        this.symbol = symbol;
        this.calculator = calculator;
    }

    public static Operation searchBy(String input) {
        for(Operation operation : Operation.values()) {
            if(isEquals(operation, input)) {
                return operation;
            }
        }
        throw new IllegalArgumentException();
    }

    public static boolean isOperation(String input) {
        boolean isOperation = false;
        for(Operation operation : Operation.values()) {
            if(isEquals(operation, input)) {
                return true;
            }
        }
        return isOperation;
    }

    private static boolean isEquals(Operation operation, String input) {
        return input.equals(operation.symbol);
    }

    public int calculate(int number1, int number2) {
        return calculator.apply(number1, number2);
    }
}
