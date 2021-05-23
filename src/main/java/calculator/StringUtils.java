package calculator;

import static calculator.NumberUtils.*;
import static java.util.Objects.*;

public final class StringUtils {

	public static boolean isBlank(String s) {
		return isNull(s) || s.equals("");
	}

	static Long[] convertStringToLong(String[] strings) {
		Long[] result = new Long[strings.length];
		for (int i = 0; i < strings.length; i++) {
			String value = strings[i];
			validateString(value);
			result[i] = Long.parseLong(value);
		}
		return result;
	}
}
