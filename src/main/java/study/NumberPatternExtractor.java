package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPatternExtractor {

	private static final String NUMBER_PATTERN_REGEX = "(//(.)\n)?(-?\\d.*)";
	private static final String DEFAULT_NUMBER_TEXT = "0";
	private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_PATTERN_REGEX);
	private static final int DELIMITER_GROUP_NO = 2;
	private static final int TEXT_GROUP_NO = 3;

	private String delimiter;
	private String numberText;

	public NumberPatternExtractor(String str) {
		matchValues(NUMBER_PATTERN.matcher(convertBlankToDefault(str)));
	}

	private String convertBlankToDefault(String str) {
		if (isBlank(str)) {
			str = DEFAULT_NUMBER_TEXT;
		}

		return str;
	}

	private boolean isBlank(String str) {
		return isNull(str) || str.isEmpty();
	}

	private boolean isNull(String str) {
		return str == null;
	}

	private void matchValues(Matcher matcher) {
		if (matcher.find()) {
			delimiter = matcher.group(DELIMITER_GROUP_NO);
			numberText = matcher.group(TEXT_GROUP_NO);
		}
	}

	public String getDelimiter() {
		if (isNull(delimiter)) {
			return "";
		}

		return delimiter;
	}

	public String getNumberText() {
		if (isNull(numberText)) {
			return "";
		}

		return numberText;
	}
}
