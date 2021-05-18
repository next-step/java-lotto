package study;

public class StringAddCalculator {

	public static int splitAndSum(String text) {
		if (text == null || text.trim().isEmpty()) {
			return 0;
		}
		if (isNumeric(text)) {
			return Integer.parseInt(text);
		}
		return -1;
	}

	private static boolean isNumeric(String text) {
		if (text == null || text.trim().isEmpty()) {
			return false;
		}
		String regex = "[0-9]+";
		return text.matches(regex);
	}

}
