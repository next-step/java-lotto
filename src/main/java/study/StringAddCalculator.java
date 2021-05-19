package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String ALL_DELIMITER_REGEX = "[,:]";
	private static final String CUSTOM_DELIMITER_REGEX = "(//(.)\n)?(-?\\d.*)";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

	private StringAddCalculator() {
	}

	public static int splitAndSum(String text) {
		if (isBlank(text)) {
			return 0;
		}

		Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(text);

		if (customDelimiterMatcher.find()) {
			String customDelimiter = customDelimiterMatcher.group(2);

			if (customDelimiter == null) {
				customDelimiter = ALL_DELIMITER_REGEX;
			}

			return addNumber(customDelimiterMatcher.group(3).split(customDelimiter));
		}

		return 0;
	}

	private static boolean isBlank(String str) {
		return str == null || str.isEmpty();
	}

	private static int addNumber(String[] strings) {
		int sum = 0;

		for (String number : strings) {
			if (number.charAt(0) == '-') {
				throw new RuntimeException();
			}

			sum += Integer.parseInt(number);
		}

		return sum;
	}

}
