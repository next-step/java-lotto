package calculator;

import java.util.Arrays;

public class StringAddCalculator {

	private static final int NULL_OR_EMPTY_VALUE = 0;
	private static final int ONLY_ONE_NUMBER = 1;
	private static final String DELIMITER = ",";

	private StringAddCalculator() {
	}

	public static int splitAndSum(String inputText) {
		if (inputText == null || inputText.isEmpty()) {
			return NULL_OR_EMPTY_VALUE;
		}

		if (inputText.length() == ONLY_ONE_NUMBER) {
			return Integer.parseInt(inputText);
		}

		String[] numbers = inputText.split(DELIMITER);
		return Arrays.stream(numbers)
				.mapToInt(Integer::parseInt)
				.sum();
	}

}
