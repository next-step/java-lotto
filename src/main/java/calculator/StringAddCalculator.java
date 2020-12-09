package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static int splitAndSum(String text) {
		if (isNullOrEmpty(text)) {
			return 0;
		}

		int number = 0;
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String numberText = m.group(2);
			number = getReduce(numberText, customDelimiter);
		} else {
			number = getReduce(text, ",|:");
		}

		return number;
	}

	private static Integer getReduce(String text, String splitter) {
		return Arrays.stream(text.split(splitter))
			.map(StringAddCalculator::parseInteger)
			.reduce(0, Integer::sum);
	}


	private static boolean isNullOrEmpty(String text) {
		return text == null || text.isEmpty();
	}

	private static int parseInteger(String text) {
		try {
			int parseInt = Integer.parseInt(text);
			isNegativeNumber(parseInt);
			return parseInt;
		} catch (NumberFormatException numberFormatException) {
			throw new NumberFormatException();
		}
	}

	private static void isNegativeNumber(int parseInt) {
		if (parseInt < 0) {
			throw new RuntimeException();
		}
	}
}
