package StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
	public static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
	private static Pattern customDelimiterPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

	private String input;

	public Input(String input) {
		this.input = input;
	}

	public String[] getStringNumbers() {
		if (validateInput(input)) {
			String[] returnValue = {"0"};
			return returnValue;
		}

		Matcher customDelimiterMatcher = getCustomDelimiterMatcher(input);

		if (customDelimiterMatcher.find()) {
			return split(getInput(customDelimiterMatcher),
				new Delimiter(getCustomDelimiter(customDelimiterMatcher)));
		}

		return split(input, new Delimiter());
	}

	private String[] split(String input, Delimiter delimiter) {
		return delimiter.splitInput(input);
	}

	private static boolean validateInput(String input) {
		if (input == null || input.isEmpty()) {
			return true;
		}
		return false;
	}

	private String getCustomDelimiter(Matcher customDelimiterMatcher) {
		return customDelimiterMatcher.group(1);
	}

	private String getInput(Matcher customDelimiterMatcher) {
		return customDelimiterMatcher.group(2);
	}

	private Matcher getCustomDelimiterMatcher(String input) {
		return customDelimiterPattern.matcher(input);
	}
}
