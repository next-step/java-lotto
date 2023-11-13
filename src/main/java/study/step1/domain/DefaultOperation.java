package study.step1.domain;

import study.step1.domain.exception.CalculatorException;

public class DefaultOperation implements Operation {

    @Override
    public int plus(int x, int y) {
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        return x - y;
    }

    @Override
    public int times(int x, int y) {
        return x * y;
    }

    @Override
    public int divide(int x, int y) {
        if (y == 0) {
            throw new CalculatorException("DivideError: 0으로는 나눌 수 없습니다.");
        }
        return x / y;
    }
}
