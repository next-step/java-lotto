package study;

public class StringAddCalculator {

	private static final String SEPERATORS = ",|:";

	public static int splitAndSum(String text) {
		if (text == null || text.trim().isEmpty()) {
			return 0;
		}
		if (isNumeric(text)) {
			return Integer.parseInt(text);
		}
		return sumNumbersBySeperators(text, SEPERATORS);
	}

	private static int sumNumbersBySeperators(String text, String seperators) {
		return sum(split(text, seperators));
	}

	private static String[] split(String text, String seperators) {
		return text.split(seperators);
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
