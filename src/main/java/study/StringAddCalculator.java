package study;

public class StringAddCalculator {

	private static final int DEFAULT_VALUE = 0;

	public static int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return DEFAULT_VALUE;
		}
		return sum(StringConverter.convertStringToArray(input));
	}

	private static int sum(String[] inputs) {
		int result = DEFAULT_VALUE;
		for (String str : inputs) {
			result += StringConverter.convertStringToInteger(str);
		}
		return result;
	}

}
