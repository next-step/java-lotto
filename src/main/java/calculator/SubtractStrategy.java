package calculator;

import calculator.domain.Number;

public class SubtractStrategy implements OperateStrategy {

    @Override
    public Number apply(Number left, Number right) {
        return left.subtract(right);
    }
}
