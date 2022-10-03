package step1.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", Number::add),
    SUBTRACT("-", Number::subtract),
    MULTIPLY("*", Number::multiply),
    DIVIDE("/", Number::divide);

    private static final String UNSUPPORTED_OPERATOR_EXCEPTION_MESSAGE = "허용하지 않는 사칙연산 기호입니다.";

    private final String operator;
    private final BiFunction<Number, Number, Number> operatorFunction;

    Operator(String operator, BiFunction<Number, Number, Number> operatorFunction) {
        this.operator = operator;
        this.operatorFunction = operatorFunction;
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
            .filter(o -> o.operator.equals(operator))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(UNSUPPORTED_OPERATOR_EXCEPTION_MESSAGE));
    }

    public Number calculate(Number left, Number right) {
        return operatorFunction.apply(left, right);
    }
}
