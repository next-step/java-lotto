package stringaddition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

	private static final String[] ZERO = {"0"};
	private static final String DELIMITER = "[,:]";
	private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
	private static final int CUSTOM_DELIMITER_GROUP = 1;
	private static final int CUSTOM_TEXT_GROUP = 2;

	private final NationalNumber nationalNumber = new NationalNumber();

	public String[] split(String text) {
		if (isBlank(text)) {
			return ZERO;
		}

		String[] split = customSplit(text);
		validate(split);

		return split;
	}

	private String[] customSplit(String text) {
		Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
		if (matcher.find()) {
			String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
			return matcher.group(CUSTOM_TEXT_GROUP).split(customDelimiter);
		}
		return text.split(DELIMITER);
	}

	private void validate(String[] split) {
		for (String s : split) {
			nationalNumber.isValid(s);
		}
	}

	private boolean isBlank(String text) {
		return text == null || text.trim().isEmpty();
	}

}
