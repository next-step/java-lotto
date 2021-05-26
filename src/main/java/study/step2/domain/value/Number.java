package study.step2.domain.value;

import java.util.Objects;

public class Number {
	private static final int RETURN_ZERO = 0;
	private static final int EFFECTIVE_LIMIT_MIN_VALUE = 0;

	private int number;

	private Number(int number) {
		this.number = number;
	}

	public int value() {
		return this.number;
	}

	public static Number generate(String text) {
		int parsedInt = parse(text);
		validateGenerateNumber(parsedInt);
		return new Number(parsedInt);
	}

	private static int parse(String text) {
		if (isNullOrEmpty(text)) {
			return RETURN_ZERO;
		}
		return Integer.parseInt(text);
	}

	private static boolean isNullOrEmpty(String text) {
		return text == null || text.trim().isEmpty();
	}

	private static void validateGenerateNumber(int parsedInt) {
		validateNotNegative(parsedInt);
	}

	private static void validateNotNegative(int parsedInt) {
		if (parsedInt < EFFECTIVE_LIMIT_MIN_VALUE) {
			throw new RuntimeException("입력된 값 중 음수가 포함되어 있습니다. : " + parsedInt);
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof Number)) {
			return false;
		}
		Number number1 = (Number)object;
		return this.value() == number1.value();
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
