package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (firstOperand, secondOperand) -> (firstOperand + secondOperand)),
    MINUS("-", (firstOperand, secondOperand) -> (firstOperand - secondOperand)),
    MULTIPLY("*", (firstOperand, secondOperand) -> (firstOperand * secondOperand)),
    DIVIDE("/", (firstOperand, secondOperand) -> {
        int result = firstOperand / secondOperand;
        if (result >= 1) {
            return result;
        }
        throw new IllegalArgumentException("나눈 값은 양의 정수여야 합니다.");
    });

    private final static Operator[] OPERATORS = Operator.values();

    private String operator;
    private BiFunction<Integer, Integer, Integer> function;

    Operator(String operator, BiFunction<Integer, Integer, Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public static Operator from(String operator) {
        return Arrays.stream(OPERATORS)
                .filter(op -> op.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자가 올바르지 않습니다."));
    }

    public int execute(int left, int right) {
        return function.apply(left, right);
    }
}
