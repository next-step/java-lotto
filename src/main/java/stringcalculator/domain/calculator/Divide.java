package stringcalculator.domain.calculator;

import stringcalculator.domain.Number;

public class Divide implements Calculator {
    @Override
    public Number calculate(Number x, Number y) {
        return x.divide(y);
    }
}
