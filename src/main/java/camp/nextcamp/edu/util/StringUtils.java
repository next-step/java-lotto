package camp.nextcamp.edu.util;

import java.util.Optional;

public class StringUtils {

	private StringUtils() {
	}

	private static final String NUMERIC_REGEX = "^[0-9]+";

	public static boolean isBlank(String param) {
		return Optional.ofNullable(param)
			.orElse("")
			.trim()
			.equals("");
	}

	public static boolean isNumeric(String word) {
		return word.matches(NUMERIC_REGEX);
	}
}
