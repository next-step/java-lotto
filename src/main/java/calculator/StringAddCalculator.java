package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final String STRING_DELIMITER_REGEX = "[,:]";
	private static final String CUSTOM_DELIMITER_PATTERN_REGEX = "//(.)\n(.*)";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN_REGEX);
	private static final String EMPTY_STRING = "";

	public static int splitAndSum(String text) {
		if (isEmpty(text)) {
			return 0;
		}

		String[] numbers = split(text);

		return sum(numbers);
	}

	private static boolean isEmpty(String text) {
		return Objects.isNull(text) || text.isEmpty();
	}

	private static String[] split(String text) {
		String[] splitString = splitByCustomDelimiter(text);

		if (isEmptyArray(splitString)) {
			splitString = text.split(STRING_DELIMITER_REGEX);
		}

		return splitString;
	}

	private static String[] splitByCustomDelimiter(String text) {
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			String targetString = matcher.group(2);

			return targetString.split(customDelimiter);
		}

		return new String[0];
	}

	private static boolean isEmptyArray(String[] strings) {
		return strings.length == 0;
	}

	private static int sum(String[] numbers) {
		return Arrays.stream(numbers)
			.mapToInt(StringAddCalculator::parseValidInt)
			.sum();
	}

	private static int parseValidInt(String text) {
		int number = parseInt(text);

		validatePositiveNumber(number);

		return number;
	}

	private static int parseInt(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException("숫자를 입력해 주세요.");
		}
	}

	private static void validatePositiveNumber(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("양수만 입력 가능합니다.");
		}
	}
}
