package step1.calculator.domain.operator;

import step1.calculator.domain.Operand;

public class AdditionOperator implements Operator {
	public static final String SYMBOL = "+";

	public static AdditionOperator create() {
		return new AdditionOperator();
	}

	public boolean isSameSymbol(String symbol) {
		return SYMBOL.equals(symbol);
	}

	@Override
	public Operand operate(Operand leftOperand, Operand rightOperand) {
		int left = leftOperand.getOperand();
		int right = rightOperand.getOperand();

		return Operand.from(left + right);
	}
}
