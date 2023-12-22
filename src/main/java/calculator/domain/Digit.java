package calculator.domain;

import java.util.Objects;

public final class Digit {
	private final int number;

	public Digit(final int input) {
		number = input;
	}

	public int number() {
		return number;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Digit digit1 = (Digit)o;
		return number == digit1.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
