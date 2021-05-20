package StringAddCalculator;

public class Number {
	public static final int MINIMUM_NUMBER = 0;
	public static final int MAXIMUM_NUMBER = 10000000;

	int number;

	public Number(String stringNumber) {
		parse(stringNumber);

		validateNegativeNumber(number);
		validateMaximumNumber(number);
	}

	public int getNumber() {
		return this.number;
	}

	private static void validateNegativeNumber(int number) {
		if (number < MINIMUM_NUMBER) {
			throw new RuntimeException("input contains few negative numbers");
		}
	}

	private void validateMaximumNumber(int number) {
		if (number > MAXIMUM_NUMBER) {
			throw new RuntimeException("each numbers can not exceed ten million");
		}
	}

	private void parse(String stringNumber) {
		try {
			this.number = Integer.parseInt(stringNumber);
		} catch (Exception e) {
			throw new RuntimeException("input contains something that is not a number");
		}
	}
}
