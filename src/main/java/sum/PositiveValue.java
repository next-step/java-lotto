package sum;

import java.util.Objects;

class PositiveValue {

	private int value;

	PositiveValue(int value) {
		checkPositive(value);

		this.value = value;
	}

	private void checkPositive(int value) {
		if (value < 0) {
			throw new IllegalArgumentException(String.format("Construct PositiveValue failed. value Must be Positive : value=%d", value));
		}
	}

	int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PositiveValue that = (PositiveValue) o;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}