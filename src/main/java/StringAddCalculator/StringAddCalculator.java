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
			return getSum(getNumbers(getInput(customDelimiterMatcher), getCustomDelimiter(customDelimiterMatcher)));
		}

		return getSum(getNumbers(input, DEFAULT_DELIMITER));
	}

	private static String[] getNumbers(String input, String delimiter) {
		return input.split(delimiter);
	}

	private static int getSum(String[] numbers) {
		int sum = 0;

		for (String stringNumber : numbers) {
			sum += new Number(stringNumber).getNumber();
		}

		return sum;
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
