package edu.nextstep.calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
	private final String CUSTOM_DELIMITER_CHECK_REGEX = "//(.)\n(.*)";
	private final String DEFAULT_DELIMITER_REGEX = ",|:";
	private final String text;

	public Text(String text) {
		this.text = text;
	}

	public boolean isEmpty() {
		return text == null || text.isEmpty();
	}

	public String[] split() {
		Matcher matchCheckResult = Pattern.compile(CUSTOM_DELIMITER_CHECK_REGEX).matcher(text);
		if (matchCheckResult.find()) {
			String customDelimiter = matchCheckResult.group(1);
			return matchCheckResult.group(2).split(customDelimiter);
		}
		return text.split(DEFAULT_DELIMITER_REGEX);
	}
}