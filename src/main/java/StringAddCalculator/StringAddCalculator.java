package StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
	private static Pattern customDelimiterPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

	public static int splitAndReturnSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		Matcher customDelimiterMatcher = getCustomDelimiterMatcher(input);

		if (customDelimiterMatcher.find()) {
			return new Numbers(
				splitInput(getInput(customDelimiterMatcher),
					new Delimiter(customDelimiterMatcher.group(1)).getDelimiter()))
				.getSum();
		}

		return new Numbers(splitInput(input, new Delimiter().getDelimiter())).getSum();
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
}
