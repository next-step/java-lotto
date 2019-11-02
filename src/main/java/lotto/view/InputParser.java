package lotto.view;

import java.util.ArrayList;
import java.util.List;

class InputParser {

	private static final String DELIMITER = ", ";

	static List<Integer> parse(String string) {
		String[] parsedString = string.split(DELIMITER);
		return parseStringToNumbers(parsedString);
	}

	private static List<Integer> parseStringToNumbers(String[] parsedString) {
		List<Integer> parsedNumbers = new ArrayList<>();
		for (String string : parsedString) {
			parsedNumbers.add(convertStringToInteger(string));
		}
		return parsedNumbers;
	}

	private static int convertStringToInteger(String string) {
		return Integer.parseInt(string);
	}

}
