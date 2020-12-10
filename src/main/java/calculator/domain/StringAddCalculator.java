package calculator.domain;

public class StringAddCalculator {
	public static int splitAndSum(String text) {
		if (isNullOrEmpty(text)) {
			return 0;
		}

		Separator separator = new Separator(text);
		SeparatedInputValues separatedInputValues = SeparatedInputValues.ofSeparator(separator.getSeparatedText());

		return separatedInputValues.sum();
	}

	private static boolean isNullOrEmpty(String text) {
		return text == null || text.isEmpty();
	}
}
