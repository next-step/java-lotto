package study.step2.domain.value;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputText {
	private static final String BASIC_DELIMITER_REGEX = ",|:";
	private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
	private static final Pattern CUSTOM_DELIMITER_READOUT_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
	private static final int CUSTOM_DELIMITER_INDEX = 1;
	private static final int CHARACTERIZED_NUMBERS_INDEX = 2;

	public static String[] split(String text) {
		Matcher matcher = CUSTOM_DELIMITER_READOUT_PATTERN.matcher(text);
		if (matcher.find()) {
			String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX) + "|" + BASIC_DELIMITER_REGEX;
			return matcher.group(CHARACTERIZED_NUMBERS_INDEX).split(customDelimiter);
		}
		return text.split(BASIC_DELIMITER_REGEX);
	}
}
