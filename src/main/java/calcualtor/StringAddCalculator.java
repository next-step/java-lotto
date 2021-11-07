package calcualtor;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calcualtor.domain.Positive;

public class StringAddCalculator {
	private static final Pattern COMMA_PATTERN = Pattern.compile("^-?\\d+[,]-?\\d+$");
	private static final Pattern COMMA_OR_COLON_PATTERN = Pattern.compile("^(-?\\d+[,:])+-?\\d+$");
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int splitAndSum(String input) {
		if (isEmpty(input)) {
			return 0;
		}

		if (isSingleCharacter(input)) {
			return Integer.parseInt(input);
		}

		if (COMMA_PATTERN.matcher(input).matches()) {
			String[] tokens = input.split(",");
			return sum(toPositives(removeZero(tokens)));
		}

		if (COMMA_OR_COLON_PATTERN.matcher(input).matches()) {
			String[] tokens = input.split(",|:");
			return sum(toPositives(removeZero(tokens)));
		}

		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			String[] tokens = matcher.group(2).split(customDelimiter);
			return sum(toPositives(removeZero(tokens)));
		}

		throw new IllegalArgumentException("input cannot be processed");
	}

	private static boolean isEmpty(String input) {
		return input == null || input.isEmpty();
	}

	private static boolean isSingleCharacter(String input) {
		return input.length() == 1;
	}

	private static String[] removeZero(String[] tokens) {
		return Arrays.stream(tokens)
			.filter(token -> !"0".equals(token))
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
