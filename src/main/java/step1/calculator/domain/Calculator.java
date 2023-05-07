package step1.calculator.domain;

import java.util.List;

import step1.calculator.CalculatorUI;

public class Calculator {
	public static final String DELIMITER = " ";

	public static final String CHECK_INPUT_MESSAGE = "입력값을 확인해주세요.";

	private final Operators operators;

	private final Operands operands;

	public Calculator(Operators operators, Operands operands) {
		this.operators = operators;
		this.operands = operands;
	}

	public static Calculator create() {
		return new Calculator(Operators.from(), Operands.from());
	}

	public Operators getOperators() {
		return operators;
	}

	public Operands getOperands() {
		return operands;
	}

	public void run() {
		String input = CalculatorUI.ready();

		put(input);

		int result = calculate();

		CalculatorUI.terminate(result);
	}

	public int calculate() {
		return operators.operate(operands);
	}

	public void put(String expression) throws IllegalArgumentException {
		validate(expression);

		splitWithDelimiter(expression)
			.forEach(this::putMathematicalToken);
	}

	private List<String> splitWithDelimiter(String input) {
		return List.of(input.split(DELIMITER));
	}

	private void validate(String text) {
		if (text == null || text.isBlank()) {
			throw new IllegalArgumentException(CHECK_INPUT_MESSAGE);
		}
	}

	private void putMathematicalToken(String token) {
		if (Operator.isOperator(token)) {
			operators.add(Operator.from(token));
		}

		if (Operand.isOperand(token)) {
			operands.add(Operand.from(token));
		}
	}
}
