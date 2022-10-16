package StringCalculator.backend.domain;

import java.util.function.BinaryOperator;

public class DivideOperator implements Operator {

    private final BinaryOperator<Integer> divide = (x, y) -> Math.round(x / y);

    @Override
    public int calculate(Operand x, Operand y) {
        if (y.isZero()) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return x.apply(divide, y);
    }
}
