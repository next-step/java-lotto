package step1;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	private static final String DEFAULT_DELIMITER = ",|:";
	private static final Pattern END_SIGN_PATTERN = Pattern.compile("//(.)\n(.*)");

	private StringUtils() {
		throw new AssertionError();
	}

	public static String[] split(String inputString) {
		Matcher m = END_SIGN_PATTERN.matcher(inputString);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return inputString.split(DEFAULT_DELIMITER);
	}

	public static boolean isEmpty(String inputString) {
		return Objects.isNull(inputString) || inputString.isEmpty();
	}
}
