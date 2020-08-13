package step1.domain;

import java.util.Objects;

public class Number {

	public static final int ZERO = 0;

	public static final Number ZERO_NUMBER = new Number(ZERO);

	private static final String NEGATIVE_NOT_ALLOWED = "숫자는 양수로 입력해주세요.";

	private final int number;

	public Number(String input) {
		this(Integer.parseInt(input));
	}

	public Number(int number) {
		if(number < ZERO) {
			throw new RuntimeException(NEGATIVE_NOT_ALLOWED);
		}
		this.number = number;
	}

	public static Number sum(Number one, Number theOther) {
		return new Number(one.number + theOther.number);
	}

	public int intValue() {
		return number;
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
