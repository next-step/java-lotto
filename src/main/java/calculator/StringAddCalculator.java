package calculator;

public class StringAddCalculator {

	public static int splitAndSum(String input) {
		return sum(split(input));
	}

	private static String[] split(String input) {
		if (isEmpty(input)) {
			return new String[]{};
		}
		return input.split(",");
	}

	private static int sum(String[] inputs) {
		int sum = 0;
		for (String s : inputs) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}

	private static boolean isEmpty(String input) {
		return input == null || input.isEmpty();
	}

}
