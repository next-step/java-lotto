package stringcalculator.calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum CalculatorOperator {
    ADD("+", Calculator.add),
    SUBTRACT("-", Calculator.subtract),
    MULTIPLY("*", Calculator.multiply),
    DIVIDE("/", Calculator.divide)
    ;
    private final String sign;
    private final BinaryOperator<Float> function;

    CalculatorOperator(final String sign, final BinaryOperator<Float> function) {
        this.sign = sign;
        this.function = function;
    }

    public BinaryOperator<Float> getFunction() {
        return function;
    }

    public static CalculatorOperator valueOfSign(final String sign) {
        return Arrays.stream(CalculatorOperator.values())
                .filter(value -> value.sign.equals(sign))
                .findAny()
                .orElse(null);
    }
}
