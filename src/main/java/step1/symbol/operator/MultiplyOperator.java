package step1.symbol.operator;

import step1.symbol.Operand;
import step1.symbol.Operator;

public class MultiplyOperator implements Operator {
    @Override
    public Operand operate(Operand firstOperand, Operand secondOperand) {
        return new Operand(firstOperand.value() * secondOperand.value());
    }
}
