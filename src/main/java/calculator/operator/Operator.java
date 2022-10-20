package calculator.operator;

import java.util.function.IntBinaryOperator;

public interface Operator extends IntBinaryOperator {
    int applyAsInt(int left, int right);
}
