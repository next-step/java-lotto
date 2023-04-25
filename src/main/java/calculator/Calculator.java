package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Calculator {
	ADD("+", (a, b) -> a + b),
	SUBTRACT("-", (a, b) -> a - b),
	MULTIPLY("*", (a, b) -> a * b),
	DIVIDE("/", (a, b) -> a / b);

	private final String symbol;
	private final BinaryOperator<Integer> operator;

	Calculator(String symbol, BinaryOperator<Integer> operator) {
		this.symbol = symbol;
		this.operator = operator;
	}

	public static Calculator from(String symbol) {
		return Arrays.stream(Calculator.values())
			.filter(operation -> operation.symbol.equals(symbol))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다 : " + symbol));
	}

	public int apply(int a, int b) {
		return operator.apply(a, b);
	}

}
