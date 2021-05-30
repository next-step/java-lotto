package stringAddCalculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
	private static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
	private static final String ZERO = "0";
	private static Pattern customDelimiterPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

	private String input;

	public Input(String input) {
		this.input = input;

		if (isEmptyOrNull(input)) {
			this.input = ZERO;
		}
	}

	public String[] getStringNumbers() {
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

	private static boolean isEmptyOrNull(String input) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Input input1 = (Input)o;
		return input.equals(input1.input);
	}

	@Override
	public int hashCode() {
		return Objects.hash(input);
	}
}
