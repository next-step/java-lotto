package im.juniq;

public class StringAddCalculator {
	public static int splitAndSum(String input) {
		if (checkNullOrEmpty(input)) {
			return 0;
		}
		String[] numbers = input.split(",");
		int criterion = 0;
		for (int i = 0; i < numbers.length; i++) {
			criterion += Integer.parseInt(numbers[i]);
		}
		return criterion;
	}

	private static boolean checkNullOrEmpty(String input) {
		if (input == null || input.isEmpty()) {
			return true;
		}
		return false;
	}
}
