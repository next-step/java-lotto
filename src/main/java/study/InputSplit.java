package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputSplit {
	private static final Integer DELIMITER = 1;
	private static final Integer SPLIT_NUMBER = 2;
	Pattern pattern = Pattern.compile("//(.)\n(.*)");
	String input;

	public InputSplit(String input) {
		this.input = input;
	}

	public String[] split() {
		if (isNullOrEmpty(input)) {
			return new String[]{"0"};
		}

		return splitDelimiter(input);
	}

	private String[] splitDelimiter(String input) {
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			String customDelimiter = matcher.group(DELIMITER);
			return matcher.group(SPLIT_NUMBER).split(customDelimiter);
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
