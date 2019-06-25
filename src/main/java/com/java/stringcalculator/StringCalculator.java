package com.java.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	static final String CUSTOM_EXPRESSSION = "//(.)\n(.*)";
	static final Pattern pattern = Pattern.compile(CUSTOM_EXPRESSSION);

	public int calculator(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		String[] numbers = Separator(input);
		int sum = 0;
		for (String number : numbers) {
			sum += numberValidator(number);
		}
		return sum;
	}

	private String[] Separator(String input) {
		Matcher matcher = pattern.matcher(input);
		if (isCustomSeparator(matcher)) {
			return customSeparator(matcher);
		}
		return defaultSeparator(input);
	}

	private String[] defaultSeparator(String input) {
		return input.split(",|:");
	}

	private String[] customSeparator(Matcher matcher) {
		String customDelimiter = matcher.group(1);
		return matcher.group(2).split(customDelimiter);
	}

	private boolean isCustomSeparator(Matcher matcher) {
		return matcher.find();
	}

	private int numberValidator(String number) {
		if (isNumber(number) && isNegative(number)) {
			throw new RuntimeException();
		}
		return Integer.parseInt(number);
	}

	private boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isNegative(String number) {
		return Integer.parseInt(number) < 0 ? true : false;
	}

}
