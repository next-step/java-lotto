package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (firstOperand, secondOperand) -> (firstOperand + secondOperand)),
    MINUS("-", (firstOperand, secondOperand) -> (firstOperand - secondOperand)),
    MULTIPLY("*", (firstOperand, secondOperand) -> (firstOperand * secondOperand)),
    DIVIDE("/", (firstOperand, secondOperand) -> {
        if (firstOperand == 0 || secondOperand == 0) {
            throw new IllegalArgumentException("0값은 나눌 수 없습니다.");
        }
        return firstOperand / secondOperand;
    });

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String operator, BiFunction<Integer, Integer, Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public static Operator from(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자가 올바르지 않습니다."));
    }

    public int execute(int left, int right) {
        return function.apply(left, right);
    }
}
