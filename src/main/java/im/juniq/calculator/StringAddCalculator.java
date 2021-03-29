package im.juniq.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final String BASIC_DELIMITER = ",:";
	private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
	private static final String NEGATIVE_EXCEPTION_MESSAGE = "숫자는 양수만 입력 가능합니다.";

	public static int splitAndSum(String input) {
		if (nullableOrEmpty(input)) {
			return 0;
		}
		String[] numbers = splitedNumbers(input);
		checkNegative(numbers);
		return sum(numbers);
	}

	private static boolean nullableOrEmpty(String text) {
		return text == null || text.isEmpty();
	}

	private static String[] splitedNumbers(String text) {
		Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
		String customDelimiter = "";
		if (m.find()) {
			customDelimiter = m.group(1);
			text = m.group(2);
		}
		return text.split("[" + BASIC_DELIMITER + customDelimiter + "]");
	}

	private static int sum(String[] numbers) {
		int criterion = 0;
		for (String number : numbers) {
			criterion += Integer.parseInt(number);
		}
		return criterion;
	}

	private static void checkNegative(String[] numbers) {
		for (String number: numbers) {
			checkNegative(number);
		}
	}

	private static void checkNegative(String number) {
		if (Integer.parseInt(number) < 0) {
			throw new RuntimeException(NEGATIVE_EXCEPTION_MESSAGE);
		}
	}
}
