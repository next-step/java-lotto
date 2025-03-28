package calculator;

import calculator.domain.Number;

public class AddStrategy implements OperateStrategy {

    @Override
    public Number apply(Number left, Number right) {
        return left.add(right);
    }
}
