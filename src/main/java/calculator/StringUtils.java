package calculator;

import static java.util.Objects.*;

public final class StringUtils {

	public static String[] getSplit(String s, String regex) {
		return s.split(regex);
	}

	public static boolean isBlank(String userInput) {
		return isNull(userInput) || userInput.equals("");
	}
}
