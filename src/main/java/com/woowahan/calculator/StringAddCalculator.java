package com.woowahan.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String DELIMITER_JOINER = "|";
	private static final String DELIMITER_COMMA = ",";
	private static final String DELIMITER_COLON = ":";
	private static final String REGEX_FIND_CUSTOM_DELIMITER = "//(.)\n(.*)";
	private static final String MSG_INPUT_REQUEST = "문자열 덧셈 계산기 입니다.식을 입력하십시오.";

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(MSG_INPUT_REQUEST);
		String input = scanner.nextLine();
		System.out.println(splitAndSum(input));
	}

	public static int splitAndSum(String input) {
		if (ValidationUtil.isNullOrEmpty(input))
			return 0;
		List<String> delimiters = new ArrayList<>();
		delimiters.add(DELIMITER_COLON);
		delimiters.add(DELIMITER_COMMA);

		String parseResult = parseInput(input, delimiters);
		String[] tokens = split(parseResult, delimiters);
		return sum(tokens);
	}

	private static String[] split(String input, List<String> delimiters) {
		return input.split(String.join(DELIMITER_JOINER, delimiters));
	}

	private static int sum(String[] tokens) {
		for (String token : tokens) {
			ValidationUtil.checkNotANumberAndNegative(token);
		}
		return Arrays.stream(tokens)
			.mapToInt(Integer::parseInt)
			.sum();
	}

	private static String parseInput(String input, List<String> delimiters) {
		Matcher m = Pattern.compile(REGEX_FIND_CUSTOM_DELIMITER).matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			delimiters.add(customDelimiter);
			return m.group(2);
		}
		return input;
	}

}
