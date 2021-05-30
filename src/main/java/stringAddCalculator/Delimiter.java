package stringAddCalculator;

import java.util.regex.Pattern;

public class Delimiter {
	private static final String DEFAULT = ",|:";
	private static final String NOT_ABLE_CHARACTER_REGEX = "([0-9a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣]+)";
	private static final int MINIMUM_LENGTH = 1;
	private static final int MAXIMUM_LENGTH = 2;
	private static Pattern notAbleCharacterPattern = Pattern.compile(NOT_ABLE_CHARACTER_REGEX);

	private String delimiter;

	public Delimiter() {
		this.delimiter = DEFAULT;
	}

	public Delimiter(String customDelimiter) {
		this.delimiter = customDelimiter;
		validateCustomDelimiterLength(customDelimiter);
		validateCustomDelimiterContents(customDelimiter);
	}

	public String[] splitInput(String input) {
		return input.split(delimiter);
	}

	private static void validateCustomDelimiterContents(String customDelimiter) {
		if (notAbleCharacterPattern.matcher(customDelimiter).find()) {
			throw new RuntimeException("custom delimiter can not contain other than special symbols");
		}
	}

	private static void validateCustomDelimiterLength(String customDelimiter) {
		if (customDelimiter.length() < MINIMUM_LENGTH
			|| customDelimiter.length() > MAXIMUM_LENGTH) {
			throw new RuntimeException("custom delimiter's length must be within 2 and longer than 0");
		}
	}
}
