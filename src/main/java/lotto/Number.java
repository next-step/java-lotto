package lotto;

import java.util.Objects;

public class Number {

	private final int number;

	public Number(int number) {
		if (number < 1 || 45 < number) {
			throw new IllegalArgumentException("Number must be between 1 and 45");
		}

		this.number = number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Number number1 = (Number)o;
		return number == number1.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
