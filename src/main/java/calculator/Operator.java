package calculator;

public enum Operator {
	ADDITION("+"),
	SUBTRACTION("-"),
	MULTIPLICATION("*"),
	DIVISION("/");

	private final String operator;

	Operator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return this.operator;
	}
}
