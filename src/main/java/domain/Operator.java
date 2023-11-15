package domain;

import java.util.function.BiFunction;

public enum Operator {

	PLUS("+", (num1, num2) -> num1 + num2),
	MINUS("-", (num1, num2) -> num1 - num2),
	MULTIPLY("*", (num1, num2) -> num1 * num2),
	DIVIDE("/", (num1, num2) -> num1 / num2);

	private String symbol;
	private BiFunction<Integer, Integer, Integer> function;

	Operator(String symbol, BiFunction<Integer, Integer, Integer> function) {
		this.symbol = symbol;
		this.function = function;
	}

	public int calculate(int num1, int num2) {
		return function.apply(num1, num2);
	}

	public String getSymbol() {
		return symbol;
	}
}