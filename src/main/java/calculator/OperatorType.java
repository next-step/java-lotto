package calculator;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum OperatorType {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> calculateLogic;

    OperatorType(String operator, BiFunction<Integer, Integer, Integer> calculateLogic) {
        this.operator = operator;
        this.calculateLogic = calculateLogic;
    }

    private boolean isOperatorTypeEquals(String type) {
        return operator.equals(type);
    }

    public static int calculate(int result, String operator, int operand) {
        return Stream.of(values())
                .filter(operatorType -> operatorType.isOperatorTypeEquals(operator))
                .mapToInt(operatorType -> operatorType.calculateLogic.apply(result, operand))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자 입니다."));
    }
}
