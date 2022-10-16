package StringCalculator.backend.domain;

import java.util.function.BinaryOperator;

public class PlusOperator implements Operator {

    BinaryOperator<Integer> plus = (x, y) -> x + y;

    @Override
    public int calculate(Operand x, Operand y) {
        return x.apply(plus, y);
    }
}
