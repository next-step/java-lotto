package calcualtor;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calcualtor.domain.Positive;
import calcualtor.exception.UtilCreationException;

public final class StringAddCalculator {
	private static final String ZERO = "0";

	private static final String COMMA_OR_COLON_DELIMITER = ",|:";

	private static final Pattern COMMA_OR_COLON_REGEX = Pattern.compile("^(-?\\d+[,:])+-?\\d+$");
	private static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.)\n(.*)");

	private StringAddCalculator() {
		throw new UtilCreationException();
	}

	public static int splitAndSum(String input) {
		if (isEmpty(input)) {
			return 0;
		}

		if (isSingleCharacter(input)) {
			return Integer.parseInt(input);
		}

		return calculate(input);
	}

	private static boolean isEmpty(String input) {
		return input == null || input.isEmpty();
	}

	private static boolean isSingleCharacter(String input) {
		return input.length() == 1;
	}

	private static int calculate(String input) {
		if (COMMA_OR_COLON_REGEX.matcher(input).matches()) {
			return sum(toPositives(removeZero(input.split(COMMA_OR_COLON_DELIMITER))));
		}

		Matcher matcher = CUSTOM_DELIMITER_REGEX.matcher(input);
		if (matcher.find()) {
			return calculateCustomDelimiter(matcher);
		}

		throw new IllegalArgumentException("input cannot be processed");
	}

	private static int calculateCustomDelimiter(Matcher matcher) {
		String customDelimiter = matcher.group(1);
		String[] tokens = matcher.group(2).split(customDelimiter);
		return sum(toPositives(removeZero(tokens)));
	}

	private static String[] removeZero(String[] tokens) {
		return Arrays.stream(tokens)
			.filter(token -> !ZERO.equals(token))
			.toArray(String[]::new);
	}

	private static Positive[] toPositives(String[] tokens) {
		return Arrays.stream(tokens)
			.map(Positive::create)
			.toArray(Positive[]::new);
	}

	private static int sum(Positive[] positives) {
		return Arrays.stream(positives)
			.mapToInt(Positive::getValue)
			.sum();
	}
}
