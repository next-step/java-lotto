package utils;

public class StringUtils {

	private static final int INT_ZERO_VALUE = 0;

	private StringUtils() {
		// empty
	}

	public static String[] split(String delimiter, String text) {
		if (isEmpty(delimiter) || isEmpty(text)) {
			return new String[]{};
		}
		return text.split(delimiter);
	}

	public static boolean isEmpty(final String text) {
		if (text == null || text.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isEmptyArray(final String[] texts) {
		if (texts == null || texts.length == INT_ZERO_VALUE) {
			return true;
		}
		return false;
	}
}
