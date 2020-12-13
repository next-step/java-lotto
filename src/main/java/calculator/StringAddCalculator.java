package calculator;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String DEFAULT_DELIMITER = ",|:";

	private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

	private static Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

	public static int splitAndSum(String inputText) {
		String text = Optional.ofNullable(inputText).orElse("");
		Matcher matcher = PATTERN.matcher(text);
		if (matcher.find()) {
			String delimiter = matcher.group(1);
			String expression = matcher.group(2);
			return sum(expression.split(delimiter));
		}
		return sum(text.split(DEFAULT_DELIMITER));
	}

	private static int sum(String[] tokens) {
		int result = 0;
		for (String input : tokens) {
			result += validatePositiveNumber(convertInteger(input));
		}
		return result;

	}

	private static int convertInteger(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		return Integer.parseInt(input);
	}

	private static int validatePositiveNumber(int value) {
		if (value < 0) {
			throw new RuntimeException();
		}
		return value;
	}

}
