package calculator.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

enum IntegerOperation {
    SUM("+", Integer::sum),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> operation;

    private static final Map<String, IntegerOperation> operations = new HashMap<>();

    static {
        for (IntegerOperation value : values()) {
            operations.put(value.operator, value);
        }
    }

    IntegerOperation(String operator, BiFunction<Integer, Integer, Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public int operate(int left, int right) {
        return this.operation.apply(left, right);
    }

    public static IntegerOperation valueOfOperator(String operator) {
        if (!operations.containsKey(operator)) {
            throw new IllegalArgumentException("허용된 연산자가 아닙니다.");
        }

        return operations.get(operator);
    }
}
