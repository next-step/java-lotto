package im.juniq;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static int splitAndSum(String input) {
		if (nullableOrEmpty(input)) {
			return 0;
		}
		return sum(splitedNumbers(input));
	}

	private static boolean nullableOrEmpty(String text) {
		return text == null || text.isEmpty();
	}

	private static String[] splitedNumbers(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		String customDelimiter = "";
		if (m.find()) {
			customDelimiter = m.group(1);
			text = m.group(2);
		}
		String[] numbers = text.split("[,:" + customDelimiter + "]");
		checkNegative(numbers);
		return numbers;
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
			throw new RuntimeException("숫자는 양수만 입력 가능합니다.");
		}
	}
}
