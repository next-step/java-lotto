package step1.impl;

import step1.OperationStrategy;

public class DivideStrategy implements OperationStrategy {
    @Override
    public int operate(int first, int second) {
        if (second == 0) {
            throw new IllegalArgumentException("0 으로는 나눌 수 없습니다.");
        }
        return first / second;
    }
}
