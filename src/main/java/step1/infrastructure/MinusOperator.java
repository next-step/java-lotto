package step1.infrastructure;

import step1.domain.Operator;

public class MinusOperator implements Operator {
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
