package calculator.domain;

public abstract class Operation {
	private static final char PLUS = '+';
	private static final char MINUS = '-';
	private static final char MULTIPLICATION = '*';
	private static final char DIVISION = '/';
	private Operation operation;

	public abstract Digit operate(final Digit digit1, final Digit digit2);

	public Operation operation(final Operator operator) {
		if (operator.operator() == PLUS) {
			operation = new Addition();
		}
		if (operator.operator() == MINUS) {
			operation = new Subtraction();
		}
		if (operator.operator() == MULTIPLICATION) {
			operation = new Multiplication();
		}
		if (operator.operator() == DIVISION) {
			operation = new Division();
		}

		return operation;
	}
}
