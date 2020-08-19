package step1.domain;

import step1.exception.StringAdderException;

import java.util.Objects;

public class Number {

	private final int number;

	public static final int ZERO = 0;

	public static final Number ZERO_NUMBER = new Number(ZERO);

	private static final String NEGATIVE_NOT_ALLOWED = "숫자는 양수로 입력해주세요.";

	private static final String PLEASE_INPUT_POSITIVE_INT = "더할 숫자는 자연수로 입력해주세요.";

	public Number(String input) {
		try {
			int number = Integer.parseInt(input);
			validatePositiveNumber(number);
			this.number = number;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new StringAdderException(PLEASE_INPUT_POSITIVE_INT);
		}
	}

	public Number(int number) {
		validatePositiveNumber(number);
		this.number = number;
	}

	public static Number sum(Number one, Number theOther) {
		return new Number(one.number + theOther.number);
	}

	public int intValue() {
		return number;
	}

	private void validatePositiveNumber(int number) {
		if(number < ZERO) {
			throw new StringAdderException(NEGATIVE_NOT_ALLOWED);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Number number1 = (Number) o;
		return number == number1.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
