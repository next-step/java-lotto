package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

	private static final String DEFAULT_DELIMITER = ",|:";
	private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile(DEFAULT_DELIMITER);

	public static int sumByDelimiter(String text) {
		if (isEmpty(text)) {
			return 0;
		}
		if (!hasDelimiter(text, DEFAULT_DELIMITER_PATTERN)) {
			return Integer.parseInt(text);
		}
		return 1;
	}

	private static boolean hasDelimiter(String text, Pattern pattern) {
		return pattern.matcher(text).find();
	}

	private static boolean isEmpty(String text) {
		return text == null || text.isEmpty();
	}

}
