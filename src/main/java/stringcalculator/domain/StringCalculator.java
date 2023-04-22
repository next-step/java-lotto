package stringcalculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum StringCalculator {

	ADD(new Operator("+"), (a, b) -> {
		Number number = new Number(a);
		return number.add(b);
	}),
	SUBTRACT(new Operator("-"), (a, b) -> {
		Number number = new Number(a);
		return number.subtract(b);
	}),
	MULTIPLY(new Operator("*"), (a, b) -> {
		Number number = new Number(a);
		return number.multiply(b);
	}),
	DIVIDE(new Operator("/"), (a, b) -> {
		Number number = new Number(a);
		return number.divide(b);
	});

	private final Operator operator;
	private final BinaryOperator<String> calculation;

	StringCalculator(Operator operator, BinaryOperator<String> calculation) {
		this.operator = operator;
		this.calculation = calculation;
	}

	public static StringCalculator findCalculator(Operator operator) {
		return Arrays.stream(values())
			.filter(e -> e.operator.equals(operator))
			.findAny()
			.orElseThrow();
	}

	public String calculate(String a, String b) {
		return calculation.apply(a, b);
	}
}
