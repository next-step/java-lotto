package nextstep.step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringSumCalculator {
	public int sum(String inputString) {
		if (inputString == null || inputString.isEmpty()) {
			return 0;
		}
		int sumResult = getSumByCustomDelimeter(inputString);
		if (sumResult > 0) {
			return sumResult;
		}
		String[] inputStrings = inputString.split(",|:");
		return Stream.of(inputStrings)
				.mapToInt(input -> getPositiveNumber(input))
				.sum();
	}

	private int getSumByCustomDelimeter(String inputString) {
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputString);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			String[] inputStrings = matcher.group(2).split(customDelimiter);
			return Stream.of(inputStrings)
					.mapToInt(input -> getPositiveNumber(input))
					.sum();
		}
		return 0;
	}

	private int getPositiveNumber(String input) {
		try {
			int positiveNumber = Integer.parseInt(input);
			if (positiveNumber < 0) {
				throw new RuntimeException("input값은 양수만 가능합니다.");
			}
			return positiveNumber;
		} catch (NumberFormatException ex) {
			throw new RuntimeException("input값은 양수만 가능합니다.");
		}
	}

}
