package edu.nextstep.calculator.domain;

import java.util.Objects;

public class Number {
	private final int number;

	private Number() {
		this.number = 0;
	}

	private Number(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("음수는 문자열 덧셈이 불가능합니다");
		}
		this.number = number;
	}

	public static Number createFromInteger(int number) {
		return new Number(number);
	}

	public static Number createFromString(String text) {
		return createFromInteger(Integer.parseInt(text));
	}

	public Number sum(Number other) {
		return createFromInteger(number + other.number);
	}

	public int getValue() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Number)) {
			return false;
		}
		Number number1 = (Number)o;
		return number == number1.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}