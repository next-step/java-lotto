package calculator;

public class StringUtil {
	private static final String SPRIT_STRING = " ";

	public static String[] splitInput(String input) {
		return input.split(SPRIT_STRING);
	}
}
