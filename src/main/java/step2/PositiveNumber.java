package step2;

import java.util.Objects;

public class PositiveNumber {

	private final int number;

	PositiveNumber(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Negative number is invalid!");
		}

		this.number = number;
	}

	public static PositiveNumber valueOf(int sum) {
		return new PositiveNumber(sum);
	}

	public static PositiveNumber valueOf(String s) {
		return new PositiveNumber(Integer.parseInt(s));
	}

	public static PositiveNumber sum(PositiveNumber num1, PositiveNumber num2) {
		if (num1 == null || num2 == null) {
			throw new IllegalArgumentException("Both parameters must not be null");
		}

		return PositiveNumber.valueOf(Integer.sum(num1.number, num2.number));
	}

	public int toInt() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PositiveNumber that = (PositiveNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
