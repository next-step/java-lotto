package calculator.operator;

import java.util.function.IntBinaryOperator;

public class MinusOperator implements IntBinaryOperator {
    @Override
    public int applyAsInt(int left, int right) {
        return left - right;
    }
}
