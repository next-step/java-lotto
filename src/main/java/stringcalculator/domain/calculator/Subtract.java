package stringcalculator.domain.calculator;

import stringcalculator.domain.Number;

public class Subtract implements Calculator {
    @Override
    public Number calculate(Number x, Number y) {
        return x.subtract(y);
    }
}
