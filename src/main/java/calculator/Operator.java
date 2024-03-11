package calculator;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

public class Operator extends Token {

    private final String sign;
    private final BiFunction<Operand, Operand, Integer> computeFunction;

    public static final Operator ADD = new Operator("+", (a, b) -> a.value() + b.value());
    public static final Operator SUBTRACT = new Operator("-", (a, b) -> a.value() - b.value());
    public static final Operator MULTIPLY = new Operator("*", (a, b) -> a.value() * b.value());
    public static final Operator DIVIDE = new Operator("/", (a, b) -> a.value() / b.value());

    private static final Map<String, Operator> OPERATOR_MAP = Map.of(
        "+", ADD,
        "-", SUBTRACT,
        "*", MULTIPLY,
        "/", DIVIDE
    );

    public Operator(String sign, BiFunction<Operand, Operand, Integer> computeFunction) {
        this.sign = sign;
        this.computeFunction = computeFunction;
    }

    public static Operator from(String sign) {
        Operator operator = OPERATOR_MAP.get(sign);
        if (operator == null) {
            throw new IllegalArgumentException("잘못된 사칙연산 기호");
        }
        return operator;
    }

    public static Operator of(Token token) {
        if (!(token instanceof Operator)) {
            throw new IllegalArgumentException("연산자 또는 피연산자가 잘못된 위치에 있음");
        }
        return (Operator) token;
    }

    public int compute(Operand left, Operand right) {
        return computeFunction.apply(left, right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operator operator = (Operator) o;
        return Objects.equals(sign, operator.sign) && Objects.equals(
            computeFunction, operator.computeFunction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sign, computeFunction);
    }

    @Override
    public String toString() {
        return "Operator{" +
            "sign='" + sign + '\'' +
            ", computeFunction=" + computeFunction +
            '}';
    }
}
