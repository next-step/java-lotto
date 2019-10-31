package step1.util;

public class StringUtils {

	private StringUtils() {

	}

	public static boolean isEmpty(String string) {
		return string == null || "".equals(string);
	}

}
