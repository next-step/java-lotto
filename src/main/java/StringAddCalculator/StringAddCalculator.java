package StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static final String DEFAULT_DELIMITER = ",|:";
	public static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
	private static Pattern customDelimiterPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

	public static int splitAndReturnSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		Matcher customDelimiterMatcher = getCustomDelimiterMatcher(input);

		if (customDelimiterMatcher.find()) {
			return new Numbers(splitInput(getInput(customDelimiterMatcher), getCustomDelimiter(customDelimiterMatcher)))
				.getSum();
		}

		return new Numbers(splitInput(input, DEFAULT_DELIMITER)).getSum();
	}

	private static String[] splitInput(String input, String delimiter) {
		return input.split(delimiter);
	}

	private static Matcher getCustomDelimiterMatcher(String input) {
		return customDelimiterPattern.matcher(input);
	}

	private static String getInput(Matcher customDelimiterMatcher) {
		return customDelimiterMatcher.group(2);
	}

	private static String getCustomDelimiter(Matcher matcher) {
		String customDelimiter = matcher.group(1);

		return customDelimiter;
	}
}
