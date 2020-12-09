package com.woowahan.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private static final String DELIMITER_JOINER = "|";
	private static final String DELIMITER_COMMA = ",";
	private static final String DELIMITER_COLON = ":";
	private static final String REGEX_FIND_CUSTOM_DELIMITER = "//(.)\n(.*)";

	private final List<String> delimiters = new ArrayList<>(Arrays.asList(DELIMITER_COMMA, DELIMITER_COLON));
	private final String expression;

	public Calculator(String expression) {
		this.expression = expression;
	}

	public int splitAndSum() {
		if (ValidationUtil.isNullOrEmpty(this.expression))
			return 0;
		String parseResult = parseInput();
		String[] tokens = split(parseResult);
		return sum(tokens);
	}

	private String[] split(String input) {
		return input.split(String.join(DELIMITER_JOINER, delimiters));
	}

	private int sum(String[] tokens) {
		for (String token : tokens) {
			ValidationUtil.checkNotANumberAndNegative(token);
		}
		return Arrays.stream(tokens)
			.mapToInt(Integer::parseInt)
			.sum();
	}

	private String parseInput() {
		Matcher m = Pattern.compile(REGEX_FIND_CUSTOM_DELIMITER).matcher(this.expression);
		if (m.find()) {
			String customDelimiter = m.group(1);
			delimiters.add(customDelimiter);
			return m.group(2);
		}
		return this.expression;
	}
}
