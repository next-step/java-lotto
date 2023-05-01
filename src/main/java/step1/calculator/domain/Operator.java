package step1.calculator.domain;

import java.util.Set;

public class Operator {
	public static final String NOT_OPERATOR_MESSAGE = "사칙연산 기호가 아닙니다.";

	public static final String INVALID_OPERATOR_MESSAGE = "연산 입력이 잘못되었습니다.";

	public static final String DENOMINATOR_CANNOT_ZERO_MESSAGE = "나눗셈 분모는 0이 될 수 없습니다.";

	private static final String PLUS = "+";

	private static final String MINUS = "-";

	private static final String MULTIPLY = "*";

	private static final String DIVIDE = "/";

	private static final Set<String> OPERATORS = Set.of(PLUS, MINUS, MULTIPLY, DIVIDE);

	private final String operator;

	public Operator(String inputOperator) {
		this.operator = inputOperator;
	}

	public static Operator from(String inputOperator) throws IllegalArgumentException {
		validate(inputOperator);

		return new Operator(inputOperator);
	}

	private static void validate(String inputOperator) throws IllegalArgumentException {
		if (!isOperator(inputOperator)) {
			throw new IllegalArgumentException(NOT_OPERATOR_MESSAGE);
		}
	}

	public static boolean isOperator(String operator) {
		return OPERATORS.contains(operator);
	}

	public Operand operate(Operand leftOperand, Operand rightOperand) throws IllegalArgumentException {
		int left = leftOperand.getOperand();
		int right = rightOperand.getOperand();

		switch (operator) {
			case PLUS:
				return Operand.from(left + right);
			case MINUS:
				return Operand.from(left - right);
			case MULTIPLY:
				return Operand.from(left * right);
			case DIVIDE:
				validateDivisor(right);
				return Operand.from(left / right);
			default:
				throw new IllegalArgumentException(INVALID_OPERATOR_MESSAGE);
		}
	}

	private void validateDivisor(int right) {
		if (this.operator.equals(DIVIDE) && right == 0) {
			throw new IllegalArgumentException(DENOMINATOR_CANNOT_ZERO_MESSAGE);
		}
	}
}
