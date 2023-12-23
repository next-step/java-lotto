package calculator.domain;

import java.util.Objects;

public final class Digit {
	private final int digit;

	public Digit(final int input) {
		digit = input;
	}

	public int digit() {
		return digit;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Digit digit1 = (Digit)o;
		return digit == digit1.digit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(digit);
	}

	public Digit add(Digit second) {
		return new Digit(this.digit + second.digit);
	}

	public Digit subtract(Digit second) {
		return new Digit(this.digit - second.digit);
	}

	public Digit multiply(Digit second) {
		return new Digit(this.digit * second.digit);
	}

	public Digit divide(Digit second) {
		return new Digit(this.digit / second.digit);
	}
}
