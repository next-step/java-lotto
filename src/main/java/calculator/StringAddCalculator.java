package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final int NULL_OR_EMPTY_RESULT = 0;
	private static final int SINGLE_NUMBER = 1;
	private static final int INDEX_OF_CUSTOM_DELIMITER = 1;
	private static final int INDEX_OF_NUMBERS = 2;
	private static final int ZERO = 0;
	private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
	private static final String DELIMITER = "[,:]";
	private static final String MESSAGE_INVALID_NUMBER = "유효하지 않은 숫자입니다.";

	private StringAddCalculator() {
	}

	public static int splitAndSum(String inputText) {
		if (isBlank(inputText)) {
			return NULL_OR_EMPTY_RESULT;
		}

		if (hasSingleNumber(inputText)) {
			return Integer.parseInt(inputText);
		}

		return sum(split(inputText));
	}

	private static String[] split(String inputText) {
		Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(inputText);
		if (matcher.find()) {
			String customDelimiter = matcher.group(INDEX_OF_CUSTOM_DELIMITER);
			return matcher.group(INDEX_OF_NUMBERS).split(customDelimiter);
		}
		return inputText.split(DELIMITER);
	}

	private static int sum(String[] numbers) {
		if (hasInvalidNumber(numbers)) {
			throw new RuntimeException(MESSAGE_INVALID_NUMBER);
		}

		return Arrays.stream(numbers)
				.mapToInt(Integer::parseInt)
				.sum();
	}

	private static int toInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new RuntimeException(MESSAGE_INVALID_NUMBER);
		}
	}

	private static boolean hasInvalidNumber(String[] numbers) {
		return Arrays.stream(numbers)
				.anyMatch(number -> toInt(number) < ZERO);
	}

	private static boolean hasSingleNumber(String inputText) {
		return inputText.length() == SINGLE_NUMBER;
	}

	private static boolean isBlank(String inputText) {
		return inputText == null || inputText.isEmpty();
	}

}
