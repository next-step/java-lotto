package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public int run(String input) {
		String[] numbers = split(input);
		int sum = sum(numbers);
		return sum;
	}

	private int sum(String[] numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += validatePositiveNumber(numbers[i]);
		}
		return sum;
	}

	public String[] split(String input) {
		if (isNullOrEmpty(input)) {
			return new String[] {"0"};
		}

		return splitDelimiter(input);
	}

	public int validatePositiveNumber(String input) {
		if (input.contains("-")) {
			throw new RuntimeException();
		}

		try {
			return Integer.valueOf(input);
		} catch (NumberFormatException ex) {
			throw new RuntimeException();
		}

	}

	private String[] splitDelimiter(String input) {
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
		}
		return input.split(",|:");
	}

	private boolean isNullOrEmpty(String input) {
		if (input == null) {
			return true;
		}
		if (input.trim().isEmpty()) {
			return true;
		}
		return false;
	}
}
