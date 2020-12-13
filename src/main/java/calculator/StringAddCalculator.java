package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
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

		if (Objects.isNull(splitString)) {
			splitString = text.split("[,:]");
		}

		return splitString;
	}

	private static String[] splitByCustomDelimiter(String text) {
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
		}

		return null;
	}

	private static int sum(String[] numbers) {
		return Arrays.stream(numbers)
			.mapToInt(StringAddCalculator::parseValidInt)
			.sum();
	}

	private static int parseValidInt(String text) {
		int number = parseInt(text);

		validateNumber(number);

		return number;
	}

	private static int parseInt(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException("숫자를 입력해 주세요.");
		}
	}

	private static void validateNumber(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("양수만 입력 가능합니다.");
		}
	}
}
