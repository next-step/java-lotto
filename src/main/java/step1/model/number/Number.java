package step1.model.number;

import step1.exception.BadRequestException;

public class Number {
	private static final String Numeric = "[0-9.]+";
	private int number;

	public Number(String number) {
		checkNumeric(number);
		this.number = Integer.parseInt(number);
	}

	public void checkNumeric(String numeric) {
		if (numeric.matches(Numeric)) {
			return;
		}
		throw new BadRequestException("");
	}

	public int getNumber() {
		return this.number;
	}

	public int plus(int a) {
		this.number += a;
		return this.number;
	}

	public int minus(int a) {
		this.number -= a;
		return this.number;
	}

	public int multiply(int a) {
		this.number *= a;
		return this.number;
	}

	public int divide(int a) {
		this.number /= a;
		return this.number;
	}
}
