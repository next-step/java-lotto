package domain.symbol.operator;

import domain.symbol.Operand;
import domain.symbol.Operator;

public class SubtractOperator implements Operator {
    @Override
    public Operand operate(Operand firstOperand, Operand secondOperand) {
        return new Operand(firstOperand.value() - secondOperand.value());
    }
}
