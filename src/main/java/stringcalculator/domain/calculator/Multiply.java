package stringcalculator.domain.calculator;

import stringcalculator.domain.Number;

public class Multiply implements Calculator {
    @Override
    public Number calculate(Number x, Number y) {
        return x.multiply(y);
    }
}
