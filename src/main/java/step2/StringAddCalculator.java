package step2;

import static java.lang.Integer.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static int splitAndSum(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}

		String[] tokens = getStringArray(text);

		return sumStringArray(tokens);
	}

	private static String[] getStringArray(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}

		return text.split(",|:");
	}

	private static int sumStringArray(String[] numbers) {
		int sum = 0;

		for (String number : numbers) {
			sum += convertToInteger(number);
		}

		return sum;
	}

	private static int convertToInteger(String number) {
		int convNumber = parseInt(number);

		if (convNumber < 0) {
			throw new IllegalArgumentException("Negative number is invalid!");
		}

		return convNumber;
	}
}
