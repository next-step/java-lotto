package calculator;

import java.util.Arrays;

public class StringAddCalculator {
	public static int splitAndSum(String text) {
		if (isNullOrEmpty(text)) {
			return 0;
		}

		return Arrays.stream(text.split(",|:"))
			.map(StringAddCalculator::parseInteger)
			.reduce(0, Integer::sum);
	}

	private static boolean isNullOrEmpty(String text) {
		return text == null || text.isEmpty();
	}

	private static int parseInteger(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException numberFormatException) {
			throw new RuntimeException();
		}
	}
}
