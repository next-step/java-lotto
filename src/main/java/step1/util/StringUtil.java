package step1.util;

import java.util.regex.Pattern;

public class StringUtil {

	public static final String EMPTY_STRING = "";

	private static final Pattern SPACE = Pattern.compile("\\s");

	private StringUtil() {}

	public static boolean isNullOrEmpty(String input) {
		return input == null || input.trim()
				.isEmpty();
	}

	public static String removeSpace(String input) {
		return SPACE.matcher(input)
				.replaceAll(EMPTY_STRING);
	}
}
