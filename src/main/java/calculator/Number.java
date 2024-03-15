package calculator;

import java.util.Objects;

public class Number {

	private final int value;

	public Number(int value) {
		this.value = value;
	}

	public Number(String value) {
		validate(value);
		this.value = Integer.valueOf(value);
	}

	private void validate(String value) {
		if (value == null || value.isBlank() || !isNumeric(value)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isNumeric(String str) {
		return str.matches("[+-]?\\d*(\\.\\d+)?");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Number))
			return false;
		Number number = (Number)o;
		return value == number.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

}
