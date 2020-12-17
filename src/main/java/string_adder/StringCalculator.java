package string_adder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class StringCalculator {

	private static final String TEXT_EMPTY = "";
	private static final String DELIMITER_FOR_SPLIT = ":|,";
	private static final String REGEX_CUSTOM_SEPARATOR = "//(.*)\n(.*)";

	int sum(String text) {
		if (isZeroReturnTarget(text)) {
			return 0;
		}

		String[] numbers = getNumbersBySplit(text);
 		return sum(numbers);
	}

	private String[] getNumbersBySplit(String text) {
		Matcher m = Pattern.compile(REGEX_CUSTOM_SEPARATOR).matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return text.split(DELIMITER_FOR_SPLIT);
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
			throw new IllegalArgumentException(msg);
		}
	}
}
