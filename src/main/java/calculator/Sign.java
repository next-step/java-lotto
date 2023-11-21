package calculator;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Sign {
	PLUS("+", Integer::sum),
	MINUS("-", (result, number) -> result - number),
	MULTIPLICATION("*", (result, number) -> result * number),
	DIVISION("/", (result, number) -> result / number);

	private final String sign;
	private final BiFunction<Integer, Integer, Integer> expression;

	Sign(String sign, BiFunction<Integer, Integer, Integer> expression) {
		this.sign = sign;
		this.expression = expression;
	}

	public String getSign() {
		return sign;
	}

	public int calculate(int result, int number) {
		return expression.apply(result, number);
	}

	private static final Map<String, String> CODE_MAP = Collections.unmodifiableMap(
			Stream.of(values()).collect(Collectors.toMap(Sign::getSign, Sign::name))
	);

	public static Sign of(final String sign){
		if(Sign.CODE_MAP.get(sign) == null){
			throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
		}
		return Sign.valueOf(Sign.CODE_MAP.get(sign));
	}
}
