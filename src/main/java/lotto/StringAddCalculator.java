package lotto;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String DEFAULT_DELIMITER = ",|:";

	public static int splitAndSum(String inputText) {
		String text = Optional.ofNullable(inputText)
			.orElse("");
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputText);
		if (m.find()) {
			String delimiter = m.group(1);
			String expression = m.group(2);
			return sum(expression.split(delimiter));
		}
		return sum(inputText.split(DEFAULT_DELIMITER));
	}

	private static int sum(String[] tokens) {
		Integer result = 0;
		for (String input : tokens) {
			result += validateNumber(convertInteger(input));
		}
		return result;

	}

	private static Integer convertInteger(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		return Integer.parseInt(input);
	}

	private static Integer validateNumber(int value) {
		if (value < 0) {
			throw new RuntimeException();
		}
		return value;
	}

}
