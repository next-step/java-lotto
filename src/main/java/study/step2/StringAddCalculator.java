package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final String BASIC_DELIMITER = ",|:";
	private static final Pattern CUSTOM_DELIMITER_READOUT_PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final int CUSTOM_DELIMITER_INDEX = 1;
	private static final int CHARACTERIZED_NUMBERS_INDEX = 2;
	private static final int RETURN_ZERO = 0;
	private static final int EFFECTIVE_LIMIT_MIN_VALUE = 0;


	public static int splitAndSum(String text) {
		if (isNullOrEmpty(text)) {
			return RETURN_ZERO;
		}
		return calculateSum(text);
	}

	private static boolean isNullOrEmpty(String text) {
		return text == null || text.isEmpty();
	}

	private static int calculateSum(String text) {
		String[] characterizedNumberArr = splitText(text);
		int[] numberArr = parseNumberArr(characterizedNumberArr);
		return sumNumberArray(numberArr);
	}

	private static String[] splitText(String text) {
		Matcher matcher = CUSTOM_DELIMITER_READOUT_PATTERN.matcher(text);
		if (matcher.find()) {
			String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX) + "|" + BASIC_DELIMITER;
			return matcher.group(CHARACTERIZED_NUMBERS_INDEX).split(customDelimiter);
		}
		return text.split(BASIC_DELIMITER);
	}

	private static int[] parseNumberArr(String[] characterizedNumberArr) {
		int[] result = new int[characterizedNumberArr.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = parseIntCharacterizedNumber(characterizedNumberArr[i]);
		}
		return result;
	}

	private static int parseIntCharacterizedNumber(String characterizedNumber) {
		if (isNullOrEmpty(characterizedNumber)) {
			return RETURN_ZERO;
		}
		int result = Integer.parseInt(characterizedNumber);
		validateGraterThanZero(result);
		return result;
	}

	private static void validateGraterThanZero(int number) {
		if (number < EFFECTIVE_LIMIT_MIN_VALUE) {
			throw new RuntimeException("0보다 작은 수가 있습니다. 0 이상의 숫자를 입력해주세요. 입력된 음수 : " + number);
		}
	}

	private static int sumNumberArray(int[] numberArray) {
		int result = RETURN_ZERO;
		for (int number : numberArray) {
			result += number;
		}
		return result;
	}
}
