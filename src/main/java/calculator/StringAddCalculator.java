package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static final String DEFAULT_DELIMITER = "[,:]";
	public static final Pattern CUSTOM_GROUP_PATTERN = Pattern.compile("//(.)\n(.*)");;
	public static final int CUSTOM_GROUP_DELIMITER = 1;
	public static final int CUSTOM_GROUP_NUMBER = 2;
	public static final int MIN_SCOPE = 0;

	public static int splitAndSum(String text) {
		if (Objects.isNull(text) || text.isEmpty()) {
			return 0;
		}

		String[] tokens = split(text);
		return sum(tokens);
	}

	private static String[] split(String text) {
		String delimiter = DEFAULT_DELIMITER;
		Matcher m = CUSTOM_GROUP_PATTERN.matcher(text);

		if (m.find()) {
			delimiter = m.group(CUSTOM_GROUP_DELIMITER);
			text = m.group(CUSTOM_GROUP_NUMBER);
		}
		return text.split(delimiter);
	}

	private static int sum(String[] tokens) {
		int sum = 0;
		for (String token : tokens) {
			sum += tokenToNumber(token);
		}
		return sum;
	}

	private static int tokenToNumber(String text) {
		int num = Integer.parseInt(text);
		if (num < MIN_SCOPE) {
			throw new IllegalArgumentException("주어진 값은 0보다 작을 수 없습니다.");
		}
		return num;
	}
}
