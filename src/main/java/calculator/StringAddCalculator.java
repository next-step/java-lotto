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
		int sum = 0;

		for (String num : tokens) {
			sum += Integer.parseInt(num);
		}
		return sum;
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
}
