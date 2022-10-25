package step1.model;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operators {
	PLUS("+", (num1, num2) -> num1 + num2),
	MINUS("-", (num1, num2) -> num1 - num2),
	MULTIPLY("*", (num1, num2) -> num1 * num2),
	DIVIDE("/", (num1, num2) -> num1 / num2);

	private final String operator;
	private final BiFunction<Integer, Integer, Integer> biFunction;

	Operators(String operator, BiFunction<Integer, Integer, Integer> biFunction) {
		this.operator = operator;
		this.biFunction = biFunction;
	}

	public static Operators findOperator(String operator) {
		return Arrays.stream(Operators.values())
				.filter(type -> operator.equals(type.operator))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	public int calculate(int a, int b) {
		return this.biFunction.apply(a, b);
	}

}
