package calculator;

import calculator.exception.WrongOperatorException;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public enum OperatorGroup {
    PLUS("+", (n1, n2) -> n1 + n2),
    MINUS("-", (n1, n2) -> n1 - n2),
    MULTI("*", (n1, n2) -> n1 * n2),
    DIVIDE("/", (n1, n2) -> n1 / n2);

    private final String operator;
    private final BinaryOperator<Double> exp;

    OperatorGroup(String operator, BinaryOperator<Double> exp) {
        this.operator = operator;
        this.exp = exp;
    }

    public static OperatorGroup findByOperator(String operator) {
        return Arrays.stream(OperatorGroup.values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(WrongOperatorException::new);
    }

    public double calculate(double left, double right) {
        return this.exp.apply(left, right);
    }
}
