package string_adder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringSplitter {

	private static final String TEXT_EMPTY = "";

	static String[] splitBySeparator(String text, String customSeparatorRegex, String defaultSeparator) {
		if (isEmptyOrSpace(text)) {
			throw new IllegalArgumentException("text is null or empty!");
		}

		Matcher m = Pattern.compile(customSeparatorRegex).matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return text.split(defaultSeparator);
	}

	private static boolean isEmptyOrSpace(String text) {
		return text == null || TEXT_EMPTY.equals(text.trim());
	}
}
