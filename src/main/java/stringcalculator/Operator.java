package stringcalculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+", Number::plus),
    SUBTRACT("-", Number::subtract),
    MULTIPLY("*", Number::multiply),
    DIVIDE("/", Number::divide);

    private final String sign;
    private final BinaryOperator<Number> operate;

    Operator(String sign, BinaryOperator<Number> operate) {
        this.sign = sign;
        this.operate = operate;
    }

    public static Operator of(String sign) {
        Operator operator = find(sign);
        if (Objects.isNull(operator)) {
            throw new CaculateException(ErrorCode.WRONG_OPERATOR);
        }
        return operator;
    }

    private static Operator find(String sign) {
        return Arrays.stream(values())
                .filter(operator -> operator.sign.equals(sign))
                .findFirst()
                .orElse(null);
    }

    public Number calculate(Number a, Number b) {
        return operate.apply(a, b);
    }
}
