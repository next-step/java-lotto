package calculator;

import calculator.domain.Number;

public class DivideStrategy implements OperateStrategy {

    @Override
    public Number apply(Number left, Number right) {
        return left.divideBy(right);
    }
}
