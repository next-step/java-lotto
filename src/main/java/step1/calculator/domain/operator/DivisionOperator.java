package step1.calculator.domain.operator;

import step1.calculator.domain.Operand;

public class DivisionOperator implements Operator {
	public static final String DENOMINATOR_CANNOT_ZERO_MESSAGE = "나눗셈 분모는 0이 될 수 없습니다.";

	public static final String SYMBOL = "/";

	public static DivisionOperator create() {
		return new DivisionOperator();
	}

	public boolean isSameSymbol(String symbol) {
		return SYMBOL.equals(symbol);
	}

	private void validateDivisor(int right) {
		if (right == 0) {
			throw new IllegalArgumentException(DENOMINATOR_CANNOT_ZERO_MESSAGE);
		}
	}

	@Override
	public Operand operate(Operand leftOperand, Operand rightOperand) {
		int left = leftOperand.getOperand();
		int right = rightOperand.getOperand();

		validateDivisor(right);

		return Operand.from(left / right);
	}
}
