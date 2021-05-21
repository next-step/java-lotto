package lotto;

import java.util.List;

public final class StringAddCalculator {

	private StringAddCalculator() {
	}

	public static int compute(String text) {
		if (Tokenizer.isEmpty(text)) {
			return 0;
		}
		return sum(Tokenizer.captureNumbers(text));
	}

	private static int sum(List<String> numbers) {
		int result = 0;
		for (String number : numbers) {
			result += Integer.parseInt(number);
		}
		return result;
	}

}
