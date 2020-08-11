package step1;

public class StringAdder {
	public static int calculate(String string) {
		if(isNullOrEmpty(string)) {
			return 0;
		}
		return Integer.parseInt(string);
	}

	private static boolean isNullOrEmpty(String string) {
		return string == null || string.trim().isEmpty();
	}
}
