package StringCalculator.backend.domain;

import java.util.function.BinaryOperator;

public class MinusOperator implements Operator {

    private final BinaryOperator<Integer> minus = (x, y) -> x - y;

    @Override
    public int calculate(Operand x, Operand y) {
        return x.apply(minus, y);
    }
}
