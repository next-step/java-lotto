package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private final static Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");
	private final static String DEFAULT_DELIMITER = "[,:]";

	public static int splitAndSum(String input) {
		return sum(split(input));
	}

	private static String[] split(String input) {
		if (isEmpty(input)) {
			return new String[]{};
		}
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
		}
		return input.split(DEFAULT_DELIMITER);
	}

	private static int sum(String[] inputs) {
		int sum = 0;
		for (String s : inputs) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}

	private static boolean isEmpty(String input) {
		return input == null || input.isEmpty();
	}

}
