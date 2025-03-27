package step1.calculator.model;

import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operation {

    ADD("+", (x, y) -> x + y),
    SUBTRACT("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);


    private static final Map<String, Operation> OPERATIONS = Map.of(
        "+", ADD,
        "-", SUBTRACT,
        "*", MULTIPLY,
        "/", DIVIDE);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operation(String operator, BiFunction<Integer, Integer, Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static Operation from(String operator) {
        return Optional.ofNullable(OPERATIONS.get(operator)).orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(int x, int y) {
        return operation.apply(x, y);
    }

}
