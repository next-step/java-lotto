package step1.calculator.domain.operator;

import step1.calculator.domain.Operand;

public class MultiplicationOperator implements Operator {
	public static final String SYMBOL = "*";

	public static MultiplicationOperator create() {
		return new MultiplicationOperator();
	}

	public boolean isSameSymbol(String symbol) {
		return SYMBOL.equals(symbol);
	}

	@Override
	public Operand operate(Operand leftOperand, Operand rightOperand) {
		int left = leftOperand.getOperand();
		int right = rightOperand.getOperand();

		return Operand.from(left * right);
	}
}
