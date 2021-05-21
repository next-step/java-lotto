package study.step2.domain.value;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputText {
	private static final String BASIC_DELIMITER_REGEX = ",|:";
	private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

	public static String[] split(String text) {
		Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1) + "|" + BASIC_DELIMITER_REGEX;
			return matcher.group(2).split(customDelimiter);
		}
		return text.split(BASIC_DELIMITER_REGEX);
	}
}
