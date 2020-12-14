package string_adder;

import java.util.stream.Stream;

class StringCalculator {

	private static final String TEXT_EMPTY = "";
	private static final String DELIMITER_FOR_SPLIT = ":|,";

	int sum(String text) {
		if (isZeroReturnTarget(text)) {
			return 0;
		}
		String[] numbers = text.split(DELIMITER_FOR_SPLIT);
		return sum(numbers);
	}

	private boolean isZeroReturnTarget(String text) {
		return text == null || TEXT_EMPTY.equals(text);
	}

	private int sum(String[] numbers) {
		return Stream.of(numbers)
				.mapToInt(Integer::parseInt)
				.peek(this::validateNotNegative)
				.sum();
	}

	private void validateNotNegative(int number) {
		if (number < 0) {
			String msg = String.format("%s is negative !", number);
			throw new RuntimeException(msg);
		}
	}
}
