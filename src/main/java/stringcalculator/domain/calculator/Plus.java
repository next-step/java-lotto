package stringcalculator.domain.calculator;

import stringcalculator.domain.Number;

public class Plus implements Calculator {
    @Override
    public Number calculate(Number x, Number y) {
        return x.add(y);
    }
}
