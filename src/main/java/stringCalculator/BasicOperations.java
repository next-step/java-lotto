package stringCalculator;

import java.util.Arrays;
import java.util.Properties;
import java.util.function.BiFunction;

public enum BasicOperations {

	PLUS("+", (num1, num2) -> num1 + num2),
	SUBTRACT("-", (num1, num2) -> num1 - num2),
	MULTIPLY("*", (num1, num2) -> num1 * num2),
	DIVIDE("/", (num1, num2) -> num1 / num2)
	;

	private final String operator;
	private final BiFunction<Integer, Integer, Integer> expression;

	BasicOperations(
		String operator,
		BiFunction<Integer, Integer, Integer> expression
	) {
		this.operator = operator;
		this.expression = expression;
	}

	public static BasicOperations match(String operator) {
		return Arrays.stream(BasicOperations.values())
			.filter(bo -> bo.equalsOperator(operator))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."));
	}

	private boolean equalsOperator(String operator) {
		return this.operator.equals(operator);
	}

	public int calculate(int num1, int num2) {
		return this.expression.apply(num1, num2);
	}
}
