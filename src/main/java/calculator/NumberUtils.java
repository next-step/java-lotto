package calculator;

public final class NumberUtils {

	public static String[] requireNumber(String[] strings) {
		for (String s : strings) {
			requireNumber(s);
		}
		return strings;
	}

	public static String requireNumber(String string) {
		for (char aChar : string.toCharArray()) {
			requireNumber(aChar);
		}
		return string;
	}

	public static void requireNumber(char aChar) {
		if (aChar == '-' || Character.isAlphabetic(aChar)) {
			throw new RuntimeException();
		}
	}
}
