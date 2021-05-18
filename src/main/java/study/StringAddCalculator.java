package study;

public class StringAddCalculator {

	public static final String SEPERATOR = ",";

	public static int splitAndSum(String text) {
		if (text == null || text.trim().isEmpty()) {
			return 0;
		}
		if (isNumeric(text)) {
			return Integer.parseInt(text);
		}
		return sumNumbersBySeperator(text, SEPERATOR);
	}

	private static int sumNumbersBySeperator(String text, String seperator) {
		return sum(split(text, seperator));
	}

	private static String[] split(String text, String seperator) {
		return text.split(seperator);
	}

	private static int sum(String[] numbers) {
		int result = 0;
		for (String number : numbers) {
			result += Integer.parseInt(number);
		}
		return result;
	}

	private static boolean isNumeric(String text) {
		if (text == null || text.trim().isEmpty()) {
			return false;
		}
		String regex = "[0-9]+";
		return text.matches(regex);
	}

}
