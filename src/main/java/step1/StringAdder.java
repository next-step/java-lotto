package step1;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringAdder {

	private static final Pattern SPACE = Pattern.compile("\\s");
	private static final Pattern DELIMITER = Pattern.compile("[,:]");
	private static final String EMPTY_STRING = "";
	private static final int ZERO = 0;

	public static int calculate(String input) {
		if(isNullOrEmpty(input)) {
			return ZERO;
		}
		return Arrays.stream(split(input))
				.map((number) -> Integer.parseInt(number))
				.reduce(ZERO, (sum, integer) -> sum + integer);
	}

	private static boolean isNullOrEmpty(String string) {
		return string == null || string.trim().isEmpty();
	}

	private static String removeSpace(String string) {
		return SPACE.matcher(string).replaceAll(EMPTY_STRING);
	}

	private static String[] split(String string) {
		String removedSpace = removeSpace(string);
		return DELIMITER.split(removedSpace);
	}
}
