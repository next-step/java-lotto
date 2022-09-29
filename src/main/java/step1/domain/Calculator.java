package step1.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Calculator {

    PLUS(new Operator('+'), (left, right) -> new PlusCalculator(left).calculate(right)),
    MINUS(new Operator('-'), (left, right) -> new MinusCalculator(left).calculate(right)),
    MULTIPLE(new Operator('*'), (left, right) -> new MultipleCalculator(left).calculate(right)),
    DIVIDE(new Operator('/'), (left, right) -> new DivideCalculator(left).calculate(right));

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
