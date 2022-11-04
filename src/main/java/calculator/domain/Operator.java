package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", Number::plus),
    MINUS("-", Number::minus),
    MULTIPLY("*", Number::multiply),
    DIVIDE("/", Number::divide);

    private static final String OPERATOR_ERROR_MESSAGE = "사칙연산에 해당하는 기호가 아닙니다.";
    private final String symbol;
    private final BiFunction<Number, Number, Number> operate;

    Operator(String symbol, BiFunction<Number, Number, Number> operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    public Number operate(Number left, Number right) {
        return operate.apply(left, right);
    }

    public static Operator getProperOperator(String string) {
        return Arrays.stream(values())
            .filter(it -> it.symbol.equals(string))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(OPERATOR_ERROR_MESSAGE));
    }

}
