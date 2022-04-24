package calculator;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Operator {
	PLUS("+", (target, value) -> target + value),
	MINUS("-", (target, value) -> target - value),
	MULTIPLICATION("*", (target, value) -> target * value),
	DIVISION("/", (target, value) -> target / value);

	private final String code;
	private final OperatorStrategy operatorStrategy;

	Operator(String code, OperatorStrategy operatorStrategy) {
		this.code = code;
		this.operatorStrategy = operatorStrategy;
	}

	public static boolean containCode(String code) {
		return Arrays.stream(Operator.values())
			.anyMatch(operator -> operator.code.equals(code));
	}

	public static Operator valueOfCode(String code) {
		return Arrays.stream(Operator.values())
			.filter(operator -> operator.code.equals(code))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("올바르지 않은 연산자 입니다. (입력가능연산자: "
				+ Arrays.stream(Operator.values())
				.map(value -> value.code)
				.collect(Collectors.joining(","))
				+ ")"));
	}

	public int calculate(int total, int value) {
		return operatorStrategy.calculate(total, value);
	}
}
