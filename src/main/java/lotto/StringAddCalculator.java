package lotto;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String DEFAULT_DELIMITER = ",|:";

	private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

	private static Matcher m;

	public static int splitAndSum(String inputText) {
		String text = Optional.ofNullable(inputText).orElse("");
		m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
		if (m.find()) {
			String delimiter = m.group(1);
			String expression = m.group(2);
			return sum(expression.split(delimiter));
		}
		return sum(inputText.split(DEFAULT_DELIMITER));
	}

	private static int sum(String[] tokens) {
		int result = 0;
		for (String input : tokens) {
			result += isPositiveNumber(convertInteger(input));
		}
		return result;

	}

	private static int convertInteger(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		return Integer.parseInt(input);
	}

	private static int isPositiveNumber(int value) {
		if (value < 0) {
			throw new RuntimeException();
		}
		return value;
	}

}
