package step1;

import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {

    ADD("+", (first, second) -> first + second),
    SUBTRACT("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> first / second),
    ;
    private final String value;
    private final BinaryOperator<Integer> operation;

    private static final Map<String, Operator> OPERATOR_MAP = initOperatorMap();

    Operator(String value, BinaryOperator<Integer> operation) {
        this.value = value;
        this.operation = operation;
    }

    private static Map<String, Operator> initOperatorMap() {
        return Stream.of(Operator.values())
                .collect(Collectors.toMap(operator -> operator.value, operator -> operator));
    }

    public static Operator toEnum(String input) {
        if (OPERATOR_MAP.containsKey(input)) {
            return OPERATOR_MAP.get(input);
        }
        throw new IllegalArgumentException("연산자가 아닌 입력입니다.");
    }

    public int operate(int operandLeft, int operandRight) {
        return this.operation.apply(operandLeft, operandRight);
    }
}
