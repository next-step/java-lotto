package calculator.model;

public enum ArithmeticEnum {
	DIVIDE("/"),
	MULTIPLY("*"),
	PLUS("+"),
	MINUS("-");

	private final String operator;

	ArithmeticEnum(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}
}
