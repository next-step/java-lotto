package calculator;

public class StringUtil {
	private static final String SPRIT_STRING = " ";

	private StringUtil() {
	}

	public static String[] splitInput(String input) {
		return input.split(SPRIT_STRING);
	}
}
