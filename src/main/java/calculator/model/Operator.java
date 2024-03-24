package calculator.model;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b) ,
    MINUS("-", (a, b) -> a - b) ,
    MULTIPLE("*", (a, b) -> a * b) ,
    DIVIDE("/", (a, b) -> a / b);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> calculateFunction;
    Operator(String operator, BiFunction<Integer, Integer, Integer> calculateFunction) {
        this.operator = operator;
        this.calculateFunction = calculateFunction;
    }

    public Integer calculate(int firstNumber, int secondNumber) {
        return this.calculateFunction.apply(firstNumber, secondNumber);
    }

    public static Operator findOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter(type -> type.operator != null)
                .filter(type -> operator.contains(type.operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("정확한 연산자를 입력해주세요"));
    }
}
