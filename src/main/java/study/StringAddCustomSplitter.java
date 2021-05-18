package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCustomSplitter extends StringAddSplitter {

	private final static String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
	private final static int CUSTOM_DELIMITER_INDEX = 1;
	private final static int CUSTOM_STRING_NUMBERS_INDEX = 2;

	public StringAddCustomSplitter(String stringNumbers) {
		super(stringNumbers);
	}

	@Override
	public void split() {
		Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(stringNumbers);
		if (matcher.find()) {
			String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
			this.tokens = matcher.group(CUSTOM_STRING_NUMBERS_INDEX).split(customDelimiter);
			validTokens();
		}
	}
}
