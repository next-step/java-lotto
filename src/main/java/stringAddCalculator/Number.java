package stringAddCalculator;

public class Number {
	private static final int MINIMUM_VALUE = 0;
	private static final int MAXIMUM_VALUE = 10000000;

	int number;

	public Number(String stringNumber) {
		parse(stringNumber);

		validateNegativeNumber(number);
		validateMaximumNumber(number);
	}

	public int getNumber() {
		return this.number;
	}

	private void validateNegativeNumber(int number) {
		if (number < MINIMUM_VALUE) {
			throw new RuntimeException("input contains few negative numbers");
		}
	}

	private void validateMaximumNumber(int number) {
		if (number > MAXIMUM_VALUE) {
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
