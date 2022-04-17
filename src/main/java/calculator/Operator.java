package calculator;

import java.util.function.BiFunction;

public enum Operator {

    ADD(Number::add),
    SUBTRACT(Number::subtract),
    MULTIPLY(Number::multiply),
    DIVIDE(Number::divide);

    private final BiFunction<Number, Number, Number> calculator;

    Operator(BiFunction<Number, Number, Number> calculator) {
        this.calculator = calculator;
    }

    public Number calculate(Number thisNumber, Number otherNumber) {
        return calculator.apply(thisNumber, otherNumber);
    }

}
