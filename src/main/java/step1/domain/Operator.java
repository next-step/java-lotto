package step1.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (firstNum, secondNum) -> firstNum + secondNum),
    MINUS("-", (firstNum, secondNum) -> firstNum - secondNum),
    MULTIPLY("*", (firstNum, secondNum) -> firstNum * secondNum),
    DIVIDE("/", (firstNum, secondNum) -> {
        if (firstNum % secondNum != 0) {
            throw new IllegalArgumentException("나눈값은 정수만 지원합니다");
        }
        return firstNum / secondNum;
    });

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int calculate(int firstNum, String operator, int secondNum) {
        return getOperator(operator).expression.apply(firstNum, secondNum);
    }

    private static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다"));
    }

}
