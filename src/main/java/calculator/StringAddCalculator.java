package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");
	private static final int CUSTOM_DELIMITER_GROUP = 1;
	private static final int CUSTOM_INPUT_GROUP = 2;
	private static final String DEFAULT_DELIMITER = "[,:]";

	public static int splitAndSum(String input) {
		return sum(parseToNonNegativeNumbers(split(input)));
	}

	private static String[] split(String input) {
		if (isEmpty(input)) {
			return new String[]{};
		}
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
		if (matcher.find()) {
			String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
			String customInput = matcher.group(CUSTOM_INPUT_GROUP);
			return customInput.split(customDelimiter);
		}
		return input.split(DEFAULT_DELIMITER);
	}

	private static List<Integer> parseToNonNegativeNumbers(String[] inputs) {
		List<Integer> numbers = new ArrayList<>();
		for (String input : inputs) {
			numbers.add(parseNonNegativeNumber(input));
		}
		return numbers;
	}

	private static int parseNonNegativeNumber(String string) {
		int number = Integer.parseInt(string);
		if (number < 0) {
			throw new RuntimeException("음수는 계산할 수 없습니다.");
		}
		return number;
	}

	private static int sum(List<Integer> numbers) {
		int sum = 0;
		for (Integer number : numbers) {
			sum += number;
		}
		return sum;
	}

	private static boolean isEmpty(String input) {
		return input == null || input.isEmpty();
	}

}
