package StringAddCalculator;

public class StringAddCalculator {
	public static final String DEFAULT_DELIMITER = ",|:";

	public static int splitAndReturnSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		return getSum(getNumbers(input));
	}

	private static String[] getNumbers(String input) {
		return input.split(DEFAULT_DELIMITER);
	}

	private static int getSum(String[] numbers) {
		int sum = 0;

		for (String number : numbers) {
			sum += Integer.parseInt(number);
		}

		return sum;
	}
}
