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

	private static String[] splitedNumbers(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		String customDelimiter = "";
		if (m.find()) {
			customDelimiter = m.group(1);
			text = m.group(2);
		}
		return text.split("[,:" + customDelimiter + "]");
	}

	private static int sum(String[] numbers) {
		int criterion = 0;
		for (String number : numbers) {
			criterion += Integer.parseInt(number);
		}
		return criterion;
	}

	private static boolean nullableOrEmpty(String input) {
		return input == null || input.isEmpty();
	}
}
