package generate;

import util.ExceptionMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
	private static final String SPLIT_COMMA = ",";
	private static final String SPLIT_COLON = ":";
	private static final String SPLIT_CUSTOM = "//(.)\n(.*)";

	public static List<String> split (String input) {
		return removeSpace(checkSeparator(input));
	}
	private static List<String> removeSpace (String[] input) {
		List<String> numbers = new ArrayList<>();

		for (String number : input) {
			numbers.add(number.trim());
		}

		return numbers;
	}

	private static String[] checkSeparator (String input) {
		if (input.contains(SPLIT_COMMA) || input.contains(SPLIT_COLON)) {
			return input.split(SPLIT_COMMA + "|" + SPLIT_COLON);
		}

		return matchSeparator(Pattern.compile(SPLIT_CUSTOM).matcher(input));
	}

	private static String[] matchSeparator (Matcher matcher) {
		if (matcher.find()) {
			String separator = matcher.group(1);

			return matcher.group(2).split(separator);
		}
		throw new IllegalArgumentException(ExceptionMessage.SEPARATOR_EXCEPTION);
	}
}
