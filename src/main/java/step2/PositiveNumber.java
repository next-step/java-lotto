package step2;

public class PositiveNumber {

	private int number;

	PositiveNumber(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Negative number is invalid!");
		}

		this.number = number;
	}

	public static PositiveNumber valueOf(String s) {
		return new PositiveNumber(Integer.parseInt(s));
	}
}
