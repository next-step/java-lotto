package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static int splitAndSum(String text) {
		if (isNullOrEmpty(text)) {
			return 0;
		}

		SeparatedInputValues separatedInputValues;

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String numberText = m.group(2);
			separatedInputValues = SeparatedInputValues.ofSplit(numberText, customDelimiter);
		} else {
			separatedInputValues = SeparatedInputValues.ofSplit(text, ",|:");
		}
		return separatedInputValues.sum();
	}

	private static boolean isNullOrEmpty(String text) {
		return text == null || text.isEmpty();
	}
}
