package lotto;

import java.util.Objects;

public class Number implements Comparable<Number> {

	private final int value;

	public Number(int value) {
		validateNumberValue(value);

		this.value = value;
	}

	private void validateNumberValue(int value) {
		if (value < 1 || 45 < value) {
			throw new IllegalArgumentException("Number must be between 1 and 45");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Number number1 = (Number)o;
		return value == number1.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public int compareTo(Number number) {
		return Integer.compare(this.value, number.value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
