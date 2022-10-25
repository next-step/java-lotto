package step1.model;

public class Calculator {
	private Operators operators;

	public void init(final String operator) {
		this.operators = Operators.findOperator(operator);
	}

	public int calculate(final int a, final int b) {
		return operators.calculate(a, b);
	}
}

