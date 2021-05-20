package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringConverter {

	private static final String DEFAULT_REGEX = "[,:]";
	private static final String NUMBER_CHECK_REGEX = "\\d+";
	private static final Pattern CUSTOM_REGEX_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int convertStringToInteger(String input) {
		if (!input.matches(NUMBER_CHECK_REGEX)) {
			throw new RuntimeException();
		}
		return Integer.parseInt(input);
	}

	public static String[] convertStringToArray(String input) {
		Matcher m = CUSTOM_REGEX_PATTERN.matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return input.split(DEFAULT_REGEX);
	}

}
