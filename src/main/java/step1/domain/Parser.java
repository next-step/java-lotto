package step1.domain;

import step1.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Parser {

	private static final String DEFAULT_DELIMITER_1 = ",";
	private static final String DEFAULT_DELIMITER_2 = ":";
	private static final String DELIMITER_COMBINER = "|";

	private static final String INPUT_STRING_FORMAT = "^%s.*$";
	private static final String CUSTOM_DELIMITER_REGEX = "//\\D\\n";
	private static final String EMPTY_STRING = "";
	private static final int CUSTOM_DELIMITER_INDEX = 2;

	private static final int MIN_NUMBER = 0;

	private final List<String> delimiters = new ArrayList<>(Arrays.asList(DEFAULT_DELIMITER_1, DEFAULT_DELIMITER_2));

	public List<Integer> parse(String stringBeforeParsing) {
		if (StringUtils.isEmpty(stringBeforeParsing)) {
			return Collections.singletonList(0);
		}

		addCustomDelimiterIfExists(stringBeforeParsing);
		String stringAfterRemovingCustomDelimiter = removeCustomDelimiterIfExists(stringBeforeParsing);
		return Collections.unmodifiableList(parseStringToNumbers(stringAfterRemovingCustomDelimiter));
	}

	private void addCustomDelimiterIfExists(String stringBeforeParsing) {
		if (stringBeforeParsing.matches(String.format(INPUT_STRING_FORMAT, CUSTOM_DELIMITER_REGEX))) {
			delimiters.add(getCustomerDelimiter(stringBeforeParsing));
		}
	}

	private String getCustomerDelimiter(String stringBeforeParsing) {
		return String.valueOf(stringBeforeParsing.charAt(CUSTOM_DELIMITER_INDEX));
	}

	private String removeCustomDelimiterIfExists(String stringBeforeParsing) {
		return stringBeforeParsing.replaceAll(CUSTOM_DELIMITER_REGEX, EMPTY_STRING);
	}

	private List<Integer> parseStringToNumbers(String stringAfterRemovingCustomDelimiter) {
		String[] parsedString = stringAfterRemovingCustomDelimiter.split(String.join(DELIMITER_COMBINER, delimiters));
		List<Integer> parsedNumbers = new ArrayList<>();
		for (String string : parsedString) {
			parsedNumbers.add(convertStringToInteger(string));
		}
		return parsedNumbers;
	}

	private int convertStringToInteger(String string) {
		try {
			return validateNotMinusInteger(Integer.parseInt(string));
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException(String.format("%s는 문자가 아닙니다!", string));
		}
	}

	private int validateNotMinusInteger(int number) {
		if (number < MIN_NUMBER) {
			throw new IllegalArgumentException(String.format("%d는 음수입니다!", number));
		}
		return number;
	}

}
