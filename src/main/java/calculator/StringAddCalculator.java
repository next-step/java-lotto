package calculator;

public class StringAddCalculator {
	public static int splitAndSum(String text) {
		if (isNullOrEmpty(text)) {
			return 0;
		}

		SeparatedInputValuesFactory factory = new SeparatedInputValuesFactory(text);
		return factory.getSeparatedInputValues().sum();
	}

	private static boolean isNullOrEmpty(String text) {
		return text == null || text.isEmpty();
	}
}
