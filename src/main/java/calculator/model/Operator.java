package calculator.model;

import calculator.exception.InvalidOperatorException;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

    ADD("+", Number::add),
    SUBTRACT("-", Number::subtract),
    MULTIPLY("*", Number::multiply),
    DIVIDE("/", Number::divide);

    private final String value;

    private final BinaryOperator<Number> calculator;

    Operator(String value, BinaryOperator<Number> calculator) {
        this.value = value;
        this.calculator = calculator;
    }

    public Number calculate(Number thisNumber, Number otherNumber) {
        return calculator.apply(thisNumber, otherNumber);
    }

    public static Operator from(String operatorAsString) {
        return Arrays.stream(values())
                .filter(operator -> operator.value.equals(operatorAsString))
                .findFirst()
                .orElseThrow(InvalidOperatorException::new);
    }

}
