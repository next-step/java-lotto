package calculator;

public class StringAddCalculator {

	private static final int NULL_OR_EMPTY_VALUE = 0;

	private StringAddCalculator() {
	}

	public static int splitAndSum(String inputText) {
		if (inputText == null || inputText.isEmpty()) {
			return NULL_OR_EMPTY_VALUE;
		}
		return Integer.parseInt(inputText);
	}

}
