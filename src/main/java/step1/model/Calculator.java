package step1.model;

public class Calculator {
	private static final String PLUS = "+";
	private static final String MINUS = "-";
	private static final String MULTIPLY = "*";
	private static final String DIVIDE = "/";

	private int result;

	public Calculator(final int result) {
		this.result = result;
	}

	public static Calculator init(final int firstValue) {
		return new Calculator(firstValue);
	}

	public void calculate(final String operator, final int b) {
		if (operator.equals(PLUS)) result = plus(result, b);
		if (operator.equals(MINUS)) result = minus(result, b);
		if (operator.equals(MULTIPLY)) result = multiply(result, b);
		if (operator.equals(DIVIDE)) result = divide(result, b);
	}

	private int plus(final int a, final int b) {
		return a + b;
	}

	private int minus(final int a, final int b) {
		return a - b;
	}

	private int multiply(final int a, final int b) {
		return a * b;
	}

	private int divide(final int a, final int b) {
		return a / b;
	}

	public int getResult() {
		return result;
	}
}
