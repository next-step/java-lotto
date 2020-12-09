package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatedInputValuesFactory {
	private static final Pattern CUSTOM_SPLIT_PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final String SIMPLE_SPLIT_PATTERN = ",|:";

	private final SeparatedInputValues separatedInputValues;

	public SeparatedInputValuesFactory(String inputText) {
		Matcher customSplitPatternMatcher = CUSTOM_SPLIT_PATTERN.matcher(inputText);
		if (customSplitPatternMatcher.find()) {
			String customDelimiter = customSplitPatternMatcher.group(1);
			String numberInputText = customSplitPatternMatcher.group(2);
			this.separatedInputValues = SeparatedInputValues.ofSeparator(numberInputText, customDelimiter);
		} else {
			this.separatedInputValues = SeparatedInputValues.ofSeparator(inputText, SIMPLE_SPLIT_PATTERN);
		}

	}

	public SeparatedInputValues getSeparatedInputValues() {
		return this.separatedInputValues;
	}
}
