package calculator;

import java.util.regex.Pattern;

public final class NumberUtils {

	private static final Pattern numberPattern = Pattern.compile("[0-9]*");

	public static void validateString(String string) {
		if (numberPattern.matcher(string).matches() == false) {
			throw new IllegalArgumentException("유효하지 않은 숫자가 사용되었습니다.");
		}
	}
}
