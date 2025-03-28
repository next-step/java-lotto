package calculator;

import calculator.domain.Number;

public class MultiplyStrategy implements OperateStrategy {

    @Override
    public Number apply(Number left, Number right) {
        return left.multiplyBy(right);
    }
}
