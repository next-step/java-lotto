package im.juniq;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static int splitAndSum(String input) {
		if (checkNullOrEmpty(input)) {
			return 0;
		}
		return sum(splitNumbers(input));
	}

	private static String[] splitNumbers(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		String customDelimiter = "";
		if (m.find()) {
			customDelimiter = m.group(1);
			text = m.group(2);
		}
		String[] numbers = text.split("[,:" + customDelimiter + "]");
		return numbers;
	}

	private static int sum(String[] numbers) {
		int criterion = 0;
		for (String number : numbers) {
			criterion += Integer.parseInt(number);
		}
		return criterion;
	}

	private static boolean checkNullOrEmpty(String input) {
		return input == null || input.isEmpty();
	}
}
