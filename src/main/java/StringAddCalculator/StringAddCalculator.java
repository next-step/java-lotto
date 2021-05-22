package StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
	private static Pattern customDelimiterPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

	public static int splitAndReturnSum(String input) {
		if (validateInput(input)) {
			return 0;
		}

		Matcher customDelimiterMatcher = getCustomDelimiterMatcher(input);

		if (customDelimiterMatcher.find()) {
			return getSum(split(getInput(customDelimiterMatcher),
				new Delimiter(getCustomDelimiter(customDelimiterMatcher))));
		}
		return getSum(split(input, new Delimiter()));
	}

	private static boolean validateInput(String input) {
		if (input == null || input.isEmpty()) {
			return true;
		}
		return false;
	}

	private static String getCustomDelimiter(Matcher customDelimiterMatcher) {
		return customDelimiterMatcher.group(1);
	}

	private static String[] split(String input, Delimiter delimiter) {
		return delimiter.splitInput(input);
	}

	private static int getSum(String[] stringNumbers) {
		Numbers numbers = new Numbers(stringNumbers);

		return numbers.getSum();
	}

	private static Matcher getCustomDelimiterMatcher(String input) {
		return customDelimiterPattern.matcher(input);
	}

	private static String getInput(Matcher customDelimiterMatcher) {
		return customDelimiterMatcher.group(2);
	}
}
