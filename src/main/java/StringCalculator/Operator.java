package StringCalculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private String symbol;
    private BinaryOperator<Integer> expression;
    public static final String INVALID_OPERATOR_MESSAGE = "사칙연산 기호가 아닙니다.";

    Operator(String symbol, BinaryOperator<Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public int calculate(int x, int y) {
        return expression.apply(x, y);
    }

    public static Operator findBySymbol(String value) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_OPERATOR_MESSAGE));
    }
}
