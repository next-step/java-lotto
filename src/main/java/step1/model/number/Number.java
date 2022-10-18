package step1.model.number;

import step1.exception.BadRequestException;

public class Number {
	private static final String Numeric = "[0-9.]+";
	private int value;

	public Number(String number) {
		checkNumeric(number);
		this.value = Integer.parseInt(number);
	}

	public void checkNumeric(String numeric) {
		if (numeric.matches(Numeric)) {
			return;
		}
		throw new BadRequestException("숫자로 변환가능한 문자열이 아닙니다.");
	}

	public int getValue() {
		return this.value;
	}

	public void plus(int a) {
		this.value += a;
	}

	public void minus(int a) {
		this.value -= a;
	}

	public void multiply(int a) {
		this.value *= a;
	}

	public void divide(int a) {
		this.value /= a;
	}
}
