package string_adder;

import java.util.stream.Stream;

class StringCalculator {

	private static final String DELIMITER_FOR_SPLIT = ":|,";
	private static final String REGEX_CUSTOM_SEPARATOR = "//(.*)\n(.*)";

	int sum(String text) {
		String[] numbers;
		try {
			numbers = StringSplitter.splitBySeparator(text, REGEX_CUSTOM_SEPARATOR, DELIMITER_FOR_SPLIT);
		} catch (IllegalArgumentException e) {
			return 0;
		}

 		return sum(numbers);
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
			throw new IllegalArgumentException(msg);
		}
	}
}
