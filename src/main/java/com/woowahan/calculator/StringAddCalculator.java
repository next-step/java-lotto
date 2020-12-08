package com.woowahan.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAddCalculator {

	private static final String DELIMITER_JOINER = "|";
	private static final String DELIMITER_COMMA = ",";
	private static final String DELIMITER_COLON = ":";

	public static int splitAndSum(String input) {
		if (ValidationUtil.isNullOrEmpty(input))
			return 0;
		List<String> delimiters = new ArrayList<>();
		delimiters.add(DELIMITER_COLON);
		delimiters.add(DELIMITER_COMMA);

		String[] tokens = split(input, delimiters);
		return sum(tokens);
	}

	private static String[] split(String input, List<String> delimiters) {
		return input.split(String.join(DELIMITER_JOINER, delimiters));
	}

	private static int sum(String[] tokens) {
		return Arrays.stream(tokens)
			.mapToInt(Integer::parseInt)
			.sum();
	}
}
