package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NumberPatternExtractor {

	private static final int DELIMITER_GROUP_NUMBER = 2;
	private static final int TEXT_GROUP_NUMBER = 3;
	private static final String DEFAULT_NUMBER = "0";
	private static final String NUMBER_PATTERN_REGEX = "(//(.)\n)?(-?\\d.*)";
	private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_PATTERN_REGEX);

	private String delimiter = "";
	private String numberText = DEFAULT_NUMBER;

	NumberPatternExtractor(String str) {
		if (isEmpty(str)) {
			return;
		}

		matchValues(getMatcher(str));
	}

	private boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}

	private Matcher getMatcher(String patternString) {
		return NUMBER_PATTERN.matcher(patternString);
	}

	private void matchValues(Matcher matcher) {
		if (matcher.find()) {
			numberText = matcher.group(TEXT_GROUP_NUMBER);
			setDelimiter(matcher.group(DELIMITER_GROUP_NUMBER));
		}
	}

	private void setDelimiter(String delimiter) {
		if (delimiter == null) {
			return;
		}

		this.delimiter = delimiter;
	}

	String getDelimiterText() {
		return delimiter;
	}

	String getNumberText() {
		return numberText;
	}

}
