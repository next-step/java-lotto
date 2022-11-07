package nextstep.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

	PLUS("+", Number::plus),
	MINUS("-", Number::minus),
	MULTIPLY("*", Number::multiply),
	DIVIDE("/", Number::divide);
	private final String operator;
	private final BiFunction<Number, Number, Number> calculator;

	Operator(final String operator, final BiFunction<Number, Number, Number> calculator) {
		this.operator = operator;
		this.calculator = calculator;
	}

	public Number calculate(final Number a, final Number b) {
		return this.calculator.apply(a, b);
	}

	public static Operator of(final String operation) {
		return Arrays.stream(values())
		             .filter(a -> a.operator.equals(operation))
		             .findFirst()
		             .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 포맷입니다. operation = " + operation));
	}
}
