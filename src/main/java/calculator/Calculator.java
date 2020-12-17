package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final String MINUS_SYMBOL = "-";
	private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
	private static final String SPLIT_PATTERN = "[,:]";
	private static final String NUMBER_PATTERN = "^[0-9]+$";
	private static Matcher matcher;

	public int calculate(String input) {
		if (isNullOrEmpty(input)) {
			return ZERO;
		}

		String[] numbers = getSplitNumber(input);

		validateNumbers(numbers);

		if (isOnlyOneNumber(numbers)) {
			return Integer.parseInt(numbers[ZERO]);
		}

		return sum(numbers);
	}

	/**
	 * 널 또는 빈문자열 체크
	 */
	private boolean isNullOrEmpty(String input) {
		return input == null || input.isEmpty();
	}

	/**
	 * 커스텀 구분자 포함여부 체크
	 */
	private boolean includeCustomDelimiter(String input) {
		matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
		return matcher.find();
	}

	/**
	 * 커스텀 구분자로 split
	 */
	private String[] splitUsingCustomDelimiter() {
		return matcher.group(TWO).split(matcher.group(ONE));
	}

	/**
	 * 커스텀 구분자를 갖고 있는지 아닌지 판단 후 각 유형에 맞게 split 결과 return
	 */
	private String[] getSplitNumber(String input) {
		String[] numbers = input.split(SPLIT_PATTERN);
		if (includeCustomDelimiter(input)) {
			numbers = splitUsingCustomDelimiter();
		}
		return numbers;
	}

	/**
	 * 음수 또는 숫자 외 문자열 입력 체크
	 */
	private void validateNumber(String number) {
		if (number.startsWith(MINUS_SYMBOL)) {
			throw new RuntimeException("음수는 입력이 불가합니다.");
		}

		if (!number.matches(NUMBER_PATTERN)) {
			throw new RuntimeException("숫자만 입력 가능합니다.");
		}
	}

	/**
	 * 음수 또는 숫자 외 문자열 입력 체크
	 */
	private void validateNumbers(String[] numbers) {
		for (String number : numbers) {
			validateNumber(number);
		}
	}

	/**
	 * 하나의 숫자만 입력한 경우 체크
	 */
	private boolean isOnlyOneNumber(String[] numbers) {
		return numbers.length == ONE;
	}

	/**
	 * 합계
	 */
	private int sum(String[] numbers) {
		int result = 0;
		for (String number : numbers) {
			result += Integer.parseInt(number);
		}
		return result;
	}
}
