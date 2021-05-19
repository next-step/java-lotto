package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static int splitAndSum(String text) {
		if (Objects.isNull(text) || text.isEmpty()) {
			return 0;
		}

		String[] tokens = split(text);
		return sum(tokens);
	}

	private static String[] split(String text) {
		String delimiter = ",|:";
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			delimiter = m.group(1);
			text = m.group(2);
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
		if (num < 0) {
			throw new IllegalArgumentException("주어진 값은 0보다 작을 수 없습니다.");
		}
		return num;
	}
}
