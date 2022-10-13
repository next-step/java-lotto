import java.util.Objects;
import java.util.function.BinaryOperator;

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
            throw new IllegalArgumentException("잘못된 연산자 입니다.");
        }
        return operator;
    }

    private static Operator find(String sign) {
        for (Operator operator : values()) {
            if (operator.sign.equals(sign)) {
                return operator;
            }
        }
        return null;
    }

    public Number calculate(Number a, Number b) {
        return operate.apply(a, b);
    }
}
