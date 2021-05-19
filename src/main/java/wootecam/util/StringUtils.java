package wootecam.util;

public class StringUtils {

	private static final String NUMERIC_REGEX = "^[0-9]+";

	public static boolean isNumeric(String numberString) {
		return numberString.matches(NUMERIC_REGEX);
	}
}
