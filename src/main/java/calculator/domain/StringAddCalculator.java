package calculator.domain;

public class StringAddCalculator {
	public static int splitAndSum(String text) {
		if (isNullOrEmpty(text)) {
			return 0;
		}

		Separator separator = new Separator(text);
		return SeparatedInputValues.ofSeparator(separator).sum();
	}

	private static boolean isNullOrEmpty(String text) {
		return text == null || text.isEmpty();
	}
}
