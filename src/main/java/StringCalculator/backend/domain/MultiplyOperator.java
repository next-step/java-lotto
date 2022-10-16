package StringCalculator.backend.domain;

import java.util.function.BinaryOperator;

public class MultiplyOperator implements Operator {

    private final BinaryOperator<Integer> multiply = (x, y) -> x * y;

    @Override
    public int calculate(Operand x, Operand y) {
        return x.apply(multiply, y);
    }
}
