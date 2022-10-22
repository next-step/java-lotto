package calculator.domain;

import static calculator.exception.ExceptionMessage.ERROR_DIVIDE_ZERO;
import static calculator.exception.ExceptionMessage.ERROR_EMPTY_OPERATOR;
import static calculator.exception.ExceptionMessage.ERROR_INVALID_OPERATOR;
import static calculator.exception.ExceptionMessage.ERROR_INVALID_VALUE_TO_DIVIDE;

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
            throw new IllegalArgumentException(ERROR_EMPTY_OPERATOR.getMessage());
        }

        return Arrays.stream(values())
            .filter(operator -> Objects.equals(operator.sign, sign))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_OPERATOR.getMessage()));
    }

    public int execute(final int x, final int y) {
        if (this == DIVIDE) {
            validateNumbers(x, y);
        }
        return this.expression.apply(x, y);
    }

    private void validateNumbers(final int x, final int y) {
        if (y == 0) {
            throw new IllegalArgumentException(ERROR_DIVIDE_ZERO.getMessage());
        }

        if ((x % y) != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_VALUE_TO_DIVIDE.getMessage());
        }
    }
}
