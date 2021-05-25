package domain;

import util.ExceptionMessage;

public class Number {
	private Integer number;

	public Number (Integer number) {
		this.number = number;
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Number number1 = (Number) o;

		return number != null ? number.equals(number1.number) : number1.number == null;
	}

	@Override
	public int hashCode () {
		return number != null ? number.hashCode() : 0;
	}

	public Integer number () {
		return number;
	}
}
