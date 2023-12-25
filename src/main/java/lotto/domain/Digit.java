package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Digit {
	private final int digit;

	public Digit(int digit) {
		this.digit = digit;
	}

	public boolean compareTo(Digit y) {
		return digit >= y.digit;
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
}
