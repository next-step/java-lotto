package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	private static final int ZERO = 0;
	private static final String MINUS_SYMBOL = "-";
	private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
	private static final String SPLIT_PATTERN = "[,:]";
	private static final String NUMBER_PATTERN = "^[0-9]+$";
	private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
	private static Matcher matcher;

	public int calculate(String input) {
		if (isNullOrEmpty(input)) {
			return ZERO;
		}

		String[] numbers = splitNumber(input);

		validateNumbers(numbers);

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
	private boolean hasCustomDelimiter(String input) {
		matcher = pattern.matcher(input);
		return matcher.find();
	}

	/**
	 * 커스텀 구분자로 split
	 */
	private String[] splitUsingCustomDelimiter() {
		return matcher.group(2).split(matcher.group(1));
	}

	/**
	 * 커스텀 구분자를 갖고 있는지 아닌지 판단 후 각 유형에 맞게 split 결과 return
	 */
	private String[] splitNumber(String input) {
		String[] numbers = input.split(SPLIT_PATTERN);
		if (hasCustomDelimiter(input)) {
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
