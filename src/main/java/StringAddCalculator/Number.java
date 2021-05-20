package StringAddCalculator;

public class Number {
	public static final int MINIMUM_NUMBER = 0;

	int number;

	public Number(String stringNumber) {
		parse(stringNumber);

		validateNegativeNumber(number);
	}

	public int getNumber() {
		return this.number;
	}

	private static void validateNegativeNumber(int number) {
		if (number < MINIMUM_NUMBER) {
			throw new RuntimeException("input contains few negative numbers");
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
