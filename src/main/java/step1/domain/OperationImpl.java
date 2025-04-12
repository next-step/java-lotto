package step1.domain;

import java.math.BigDecimal;

/**
 * Operation을 실제로 구현한 사칙연산 구현체
 */
public class OperationImpl {
    public static final Operation ADDITION = (left, right) -> Number.of(left.getValue().add(right.getValue()));

    public static final Operation SUBTRACTION = (left, right) -> Number.of(left.getValue().subtract(right.getValue()));

    public static final Operation MULTIPLICATION = (left, right) -> Number.of(left.getValue().multiply(right.getValue()));

    public static final Operation DIVISION = (left, right) -> {
        if (right.getValue().compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return Number.of(left.getValue().divide(right.getValue(), 0, BigDecimal.ROUND_HALF_UP));
    };
}
