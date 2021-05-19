package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final String BASIC_DELIMITER = ",|:";

	public static int splitAndSum(String text) {
		if (isNullOrEmpty(text)) {
			return 0;
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
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1) + "|" + BASIC_DELIMITER;
			return m.group(2).split(customDelimiter);
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
			return 0;
		}
		int result = Integer.parseInt(characterizedNumber);
		isValidGraterThanZero(result);
		return result;
	}

	private static boolean isValidGraterThanZero(int number) {
		if (0 <= number) {
			return true;
		}
		throw new RuntimeException("0보다 작은 수가 있습니다. 0 이상의 숫자를 입력해주세요. 입력된 음수 : " + number);
	}

	private static int sumNumberArray(int[] numberArray) {
		int result = 0;
		for (int number : numberArray) {
			result += number;
		}
		return result;
	}
}
