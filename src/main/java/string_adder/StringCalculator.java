package string_adder;

import java.util.stream.Stream;

class StringCalculator {

	private static final String TEXT_EMPTY = "";
	private static final String SEPARATOR_COMMA = ",";

	int sum(String text) {
		if (isZeroReturnTarget(text)) {
			return 0;
		}
		String[] numbers = text.split(SEPARATOR_COMMA);
		return sum(numbers);
	}

	private boolean isZeroReturnTarget(String text) {
		return text == null || TEXT_EMPTY.equals(text);
	}

	private int sum(String[] numbers) {
		return Stream.of(numbers)
				.mapToInt(Integer::parseInt)
				.sum();
	}
}
