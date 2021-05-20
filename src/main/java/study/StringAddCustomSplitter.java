package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCustomSplitter extends StringAddSplitter {

	private final static String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
	private final static int CUSTOM_DELIMITER_INDEX = 1;
	private final static int CUSTOM_STRING_NUMBERS_INDEX = 2;
	private final static Pattern CUSTOM_SPLITTER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

	public StringAddCustomSplitter(String stringNumbers) {
		super(stringNumbers);
	}

	@Override
	public void split() {
		Matcher customSplitterPattern = CUSTOM_SPLITTER_PATTERN.matcher(stringNumbers);
		if (customSplitterPattern.find()) {
			String customDelimiter = customSplitterPattern.group(CUSTOM_DELIMITER_INDEX);
			this.tokens = customSplitterPattern.group(CUSTOM_STRING_NUMBERS_INDEX).split(customDelimiter);
			validateTokens();
		}
	}
}
