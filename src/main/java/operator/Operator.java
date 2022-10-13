package operator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BinaryOperator;

public enum Operator {
    ADD("+", ((x, y) -> x + y)),
    SUBTRACT("-", ((x, y) -> x - y)),
    MULTIPLY("*", ((x, y) -> x * y)),
    DIVIDE("/", ((x, y) -> x / y));

    private final String sign;
    public BinaryOperator<Integer> expression;

    Operator(String sign, BinaryOperator<Integer> expression) {
        this.sign = sign;
        this.expression = expression;
    }

    public static Operator findBySign(final String sign) {
        if (sign == null || sign.isEmpty()) {
            throw new IllegalArgumentException("부호가 누락되었습니다.");
        }

        return Arrays.stream(values())
            .filter(operator -> Objects.equals(operator.sign, sign))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("잘못된 부호입니다."));
    }

    public int execute(final int x, final int y) {
        if (this == DIVIDE) {
            validateNumbers(x, y);
        }
        return this.expression.apply(x, y);
    }

    private void validateNumbers(final int x, final int y) {
        if (y == 0) {
            throw new IllegalArgumentException("0은 나눗셈의 피연산자로 사용될 수 없습니다.");
        }

        if ((x % y) != 0) {
            throw new IllegalArgumentException("결과 값이 정수로 떨어지는 값만 계산 가능합니다.");
        }
    }
}
