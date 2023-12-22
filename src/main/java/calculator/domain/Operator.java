package calculator.domain;

import java.util.Objects;

public final class Operator {
	private final char operator;

	public Operator(final char character) {
		operator = character;
	}

	public char operator() {
		return operator;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Operator operator1 = (Operator)o;
		return operator == operator1.operator;
	}

	@Override
	public int hashCode() {
		return Objects.hash(operator);
	}
}
