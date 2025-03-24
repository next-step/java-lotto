package domain.symbol;

public interface Operator {
    Operand operate(Operand firstOperand, Operand secondOperand);
}
