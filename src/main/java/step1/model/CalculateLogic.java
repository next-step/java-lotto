package step1.model;

import java.util.function.BinaryOperator;

public enum CalculateLogic {

	PLUS("+", (x, y) -> x + y),
	MINUS("-", (x, y) -> x - y),
	TIMES("*", (x, y) -> x * y),
	DIVIDE("/", (x, y) -> x / y);

	private final String symbol;
	private final BinaryOperator<Integer> operator;

	CalculateLogic(String symbol, BinaryOperator<Integer> operator) {
		this.symbol = symbol;
		this.operator = operator;
	}

	public int calculate(int num1, int num2) {
		return operator.apply(num1, num2);
	}
}
