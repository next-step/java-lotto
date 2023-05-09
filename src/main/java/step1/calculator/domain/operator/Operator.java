package step1.calculator.domain.operator;

import step1.calculator.domain.Operand;

public interface Operator {
	Operand operate(Operand leftOperand, Operand rightOperand);

	boolean isSameSymbol(String symbol);
}
