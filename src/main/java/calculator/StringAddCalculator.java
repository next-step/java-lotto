package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String DELIMITER = ",|:";
	private static final String INPUT_ERROR_MESSAGE = "숫자는 자연수만 입력헤주세요.";

	public static int splitAndSum(String text) {
		if (empty(text)) return 0;
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
		return matcher.find() ? splitByCustomDelimiter(matcher) : splitByDelimiter(text);
	}

	private static int splitByCustomDelimiter(Matcher matcher) {
		String customDelimiter = matcher.group(1);
		String[] tokens = matcher.group(2).split(customDelimiter);
		return stringArrayToIntSum(tokens);
	}

	private static int splitByDelimiter(String text) {
		String[] split = text.split(DELIMITER);
		return stringArrayToIntSum(split);
	}

	private static int stringArrayToIntSum(String[] numbers) {
		return Arrays.stream(numbers).mapToInt(StringAddCalculator::stringToInt).sum();
	}

	private static int stringToInt(String number) {
		if (!numeric(number)) {
			throw new RuntimeException(INPUT_ERROR_MESSAGE);
		}
		return Integer.parseInt(number);
	}

	private static boolean numeric(String number) {
		return number.chars().allMatch(Character::isDigit);
	}

	private static boolean empty(String text) {
		return text == null || text.isEmpty();
	}
}
