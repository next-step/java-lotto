package im.juniq;

public class StringAddCalculator {
	public static int splitAndSum(String input) {
		if (checkNullOrEmpty(input)) {
			return 0;
		}
		return Integer.parseInt(input);
	}

	private static boolean checkNullOrEmpty(String input) {
		if (input == null || input.isEmpty()) {
			return true;
		}
		return false;
	}
}
