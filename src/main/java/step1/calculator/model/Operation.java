package step1.calculator.model;

import java.util.Map;
import java.util.Optional;

public enum Operation {

    ADD("+") {
        @Override
        public int calculate(int x, int y) {
            return x + y;
        }
    }, SUBTRACT("-") {
        @Override
        public int calculate(int x, int y) {
            return x - y;
        }
    }, MULTIPLY("*") {
        @Override
        public int calculate(int x, int y) {
            return x * y;
        }
    }, DIVIDE("/") {
        @Override
        public int calculate(int x, int y) {
            return x / y;
        }
    };

    private final String operator;

    Operation(String operator) {
        this.operator = operator;
    }

    private static final Map<String, Operation> OPERATIONS = Map.of("+", ADD, "-", SUBTRACT, "*", MULTIPLY, "/", DIVIDE);

    public static Operation from(String operator) {
        return Optional.ofNullable(OPERATIONS.get(operator)).orElseThrow(IllegalArgumentException::new);
    }

    public abstract int calculate(int x, int y);

}
