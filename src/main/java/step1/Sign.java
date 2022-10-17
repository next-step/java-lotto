package step1;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Sign {
	PLUS("+", (a, b) -> a + b),
	MINUS("-", (a, b) -> a - b),
	MULTIPLY("*", (a, b) -> a * b),
	DIVIDE("/", (a, b) -> {
		if (b == 0) {
			throw new ArithmeticException("0으로 나눌수가 없습니다");
		}
		if (a % b != 0) {
			throw new ArithmeticException("나누기 결과는 정수만 가능합니다");
		}
		return a / b;
	});

	private static final Map<String, Sign> SIGN_MAP = Collections.unmodifiableMap(
		Stream.of(values())
			.collect(Collectors.toMap(Sign::getSign, Function.identity()))
	);

	private static final String SIGN_EXCEPTION_MESSAGE = "사칙연산 기호가 아닙니다";
	private final String sign;
	private final BiFunction<Integer, Integer, Integer> expression;

	Sign(String sign, BiFunction<Integer, Integer, Integer> expression) {
		this.sign = sign;
		this.expression = expression;
	}

	public static int result(String sign, int result, int term) {
		return find(sign).expression.apply(result, term);
	}

	public static Sign find(String sign) {
		if (!SIGN_MAP.containsKey(sign)) {
			throw new IllegalArgumentException(SIGN_EXCEPTION_MESSAGE);
		}
		return SIGN_MAP.get(sign);
	}

	public String getSign() {
		return sign;
	}
}
