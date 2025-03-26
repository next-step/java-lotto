package calculator;

import calculator.domain.Number;

public interface OperateStrategy {

    Number apply(Number left, Number right);
}
