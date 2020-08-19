package step3.utils;

import java.util.regex.Pattern;

public class StringUtils {

	private static final String EMPTY_STRING = "";
	private static final Pattern SPACE = Pattern.compile("\\s");
	private static final Pattern COMMA = Pattern.compile(",");

	private StringUtils() {}

	public static String[] splitByDelimiter(String input) {
		String replaced = SPACE.matcher(input).replaceAll(EMPTY_STRING);
		return COMMA.split(replaced);
	}
}
