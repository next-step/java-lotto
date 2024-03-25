package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
	PLUS("+", (x, y) -> x + y),
	MINUS("-", (x, y) -> x - y),
	MULTIPLY("*", (x, y) -> x * y),
	DIVIDE("/", (x, y) -> x / y);

	private final String symbol;
	private final BiFunction<Integer, Integer, Integer> expression;

	Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
		this.symbol = symbol;
		this.expression = expression;
	}

	public String getSymbol() {
		return symbol;
	}

	public static Operator getOperatorBySymbol(String symbol) {
		return Arrays.stream(values())
				.filter(x -> symbol.equals(x.getSymbol()))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산 기호가 아닙니다."));
	}

	public int calculate(int x, int y) {
		return expression.apply(x, y);
	}

	public Number calculate(Number x, Number y) {
		return new Number(calculate(x.getNumber(), y.getNumber()));
	}
}
