package step2;

import static java.lang.Integer.*;

public class StringAddCalculator {
	public static int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		if (input.contains(",")) {
			return getSplitSumResult(input);
		}

		return parseInt(input);
	}

	private static int getSplitSumResult(String input) {
		String[] numbers = input.split(",|:");
		int sum = 0;

		for (String number : numbers) {
			sum += convertToInteger(number);
		}

		return sum;
	}

	private static int convertToInteger(String number) {
		int convNumber = parseInt(number);

		if (convNumber < 0) {
			throw new IllegalArgumentException("Negative number is invalid!");
		}

		return convNumber;
	}
}
