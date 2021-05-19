package study;

import static study.PatternGroup.*;
import static study.DefaultText.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPatternExtractor {

	private static final String NUMBER_PATTERN_REGEX = "(//(.)\n)?(-?\\d.*)";
	private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_PATTERN_REGEX);

	private String delimiter = "";
	private String numberText = "";

	public NumberPatternExtractor(String str) {
		matchValues(getMatcher(convertBlankToDefault(str)));
	}

	private String convertBlankToDefault(String str) {
		if (isBlank(str)) {
			return NUMBER.getText();
		}

		return str;
	}

	private boolean isBlank(String str) {
		return isNull(str) || str.isEmpty();
	}

	private boolean isNull(String str) {
		return str == null;
	}

	private Matcher getMatcher(String patternString) {
		return NUMBER_PATTERN.matcher(patternString);
	}

	private void matchValues(Matcher matcher) {
		if (matcher.find()) {
			delimiter = matcher.group(DELIMITER.getNo());
			numberText = matcher.group(TEXT.getNo());
		}
	}

	public String getDelimiterText() {
		if (isNull(delimiter)) {
			return EMPTY.getText();
		}

		return delimiter;
	}

	public String getNumberText() {
		return numberText;
	}
}
