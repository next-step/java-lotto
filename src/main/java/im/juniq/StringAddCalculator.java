package im.juniq;

public class StringAddCalculator {
	public static int splitAndSum(String input) {
		if (checkNullOrEmpty(input)) {
			return 0;
		}
		return sum(input.split(","));
	}

	private static int sum(String[] numbers) {
		int criterion = 0;
		for (String number : numbers) {
			criterion += Integer.parseInt(number);
		}
		return criterion;
	}

	private static boolean checkNullOrEmpty(String input) {
		return input == null || input.isEmpty();
	}
}
