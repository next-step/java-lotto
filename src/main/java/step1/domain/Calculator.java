package step1.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Calculator {

    PLUS(new Operator('+'), Number::plus),
    MINUS(new Operator('-'), Number::minus),
    MULTIPLE(new Operator('*'), Number::multiple),
    DIVIDE(new Operator('/'), Number::divide);

    private final Operator operator;
    private final BinaryOperator<Number> binaryOperator;

    Calculator(Operator operator, BinaryOperator<Number> binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }

    public static Calculator findBy(Operator operator) {
        return Arrays.stream(Calculator.values())
            .filter(o -> o.operator.equals(operator))
            .findFirst()
            .orElseThrow();
    }

    public Number apply(Number left, Number right) {
        return binaryOperator.apply(left, right);
    }
}
