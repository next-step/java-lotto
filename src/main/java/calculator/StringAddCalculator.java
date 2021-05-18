package calculator;

public class StringAddCalculator {

	public static int splitAndSum(String input) {
		if (isEmpty(input)) {
			return 0;
		}
		return Integer.parseInt(input);
	}

	private static boolean isEmpty(String input) {
		return input == null || input.isEmpty();
	}

}
