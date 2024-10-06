package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Sign {
    PLUS("+", Sign::plus),
    MINUS("-", Sign::minus),
    MULTIPLY("*", Sign::multiply),
    DIVIDE("/", Sign::divide);

    private final String sign;
    private final BinaryOperator<Integer> operator;

    Sign(final String sign, final BinaryOperator<Integer> operator) {
        this.sign = sign;
        this.operator = operator;
    }

    public static Sign findSign(final String sign) {
        return Arrays.stream(values())
            .filter(o -> o.sign.equals(sign))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 부호입니다: " + sign));
    }

    public int apply(int a, int b) {
        return operator.apply(a, b);
    }

    private static int plus(final int a, final int b) {
        return a + b;
    }

    private static int minus(final int a, final int b) {
        return a - b;
    }

    private static int multiply(final int a, final int b) {
        return a * b;
    }

    private static int divide(final int a, final int b) {
        final double result = (double) a / b;

        if (!isInteger(result)) {
            throw new IllegalArgumentException("결과 값이 정수로 떨어지지 않습니다.");
        }

        return (int) result;
    }

    private static boolean isInteger(final double value) {
        return value == (int) value;
    }
}
