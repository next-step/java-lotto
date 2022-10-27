package caculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    ADDITION("+", (a, b) -> (a + b)),
    SUBTRACTION("-", (a, b) -> (a - b)),
    MULTIPLICATION("*", (a, b) -> (a * b)),
    DIVISION("/", (a, b) -> (a / b));

    private final String sign;
    private final BinaryOperator<Integer> binaryOperator;

    Operator(String sign, BinaryOperator<Integer> binaryOperator) {
        this.sign = sign;
        this.binaryOperator = binaryOperator;
    }

    public int calculate(int num1, int num2) {
        return binaryOperator.apply(num1, num2);
    }

    public static Operator of(String sign) {
        return Arrays.stream(values())
                .filter(operator -> operator.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호만 입력 가능합니다."));
    }
}
