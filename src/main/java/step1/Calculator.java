package step1;

import java.util.regex.Pattern;

public class Calculator {
	private static final int INIT_VALUE = 0;
	private static final Pattern POSITIVE_NUMBER = Pattern.compile("^[0-9]+$");

	public static int getIntegerSumOfStrings(String inputString) {
		if (StringUtils.isEmpty(inputString)) {
			return INIT_VALUE;
		}

		String[] strings = StringUtils.split(inputString);
		int sum = INIT_VALUE;
		for (String number : strings) {
			sum += validNumber(number);
		}
		return sum;
	}

	private static int validNumber(String number) {
		if (POSITIVE_NUMBER.matcher(number).matches()) {
			return Integer.parseInt(number);
		}
		throw new RuntimeException("문자열 덧셈 계산기는 양수만 가능합니다.");
	}
}
