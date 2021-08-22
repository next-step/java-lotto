package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private final static String DEFAULT_DELIMITER = ",|:";
	private final static String CUSTOM_DELIMITER = "//(.)\\n(.*)";
	private final static int ZERO = 0;

	private boolean isNullOrEmpty(String input) {
		return input == null || input.trim().isEmpty();
	}

	private String[] splitInputValue(String input) {
		Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
		Matcher matcher = pattern.matcher(input);

		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			String values = matcher.group(2);
			return values.split(customDelimiter);
		}

		return input.split(DEFAULT_DELIMITER);
	}

	private int sumValues(String[] values) {
		return Arrays.stream(values)
			.map(Number::new)
			.mapToInt(Number::getValue)
			.sum();
	}

	public int splitAndSum(String input) {
		if (isNullOrEmpty(input)) {
			return ZERO;
		}
		String[] values = splitInputValue(input);

		return sumValues(values);
	}
}