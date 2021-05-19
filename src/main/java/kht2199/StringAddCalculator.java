package kht2199;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String regex = "[,:]";

	private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

	public static int splitAndSum(String text) {
		if (!checkValidationInputText(text)) {
			return 0;
		}

		String[] tokens = splitText(text);
		Integer[] intTokens = stringToInt(tokens);;
		for (Integer token : intTokens) {
			checkValidationToken(token);
		}

		return accumulation(intTokens);
	}

	private static int accumulation(Integer[] values) {
		int sum = 0;
		for (Integer integer : values) {
			sum += integer;
		}
		return sum;
	}

	private static String[] splitText(String text) {
		Matcher matcher = pattern.matcher(text);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
		}
		return text.split(regex);
	}

	/**
	 *
	 * @param token 토큰
	 * @throws RuntimeException token 검증 실패시 발생.
	 */
	private static void checkValidationToken(Integer token) throws RuntimeException {
		if (token < 0) {
			throw new RuntimeException("token is less than 0." + token);
		}
	}

	/**
	 *
	 * @param text input text
	 * @return input text 유효성 검증
	 */
	private static boolean checkValidationInputText(String text) {
		if (text == null) {
			return false;
		}

		return !text.isEmpty();
	}

	private static Integer[] stringToInt(String[] stringTokens) {
		Integer[] result = new Integer[stringTokens.length];
		for (int i = 0, stringTokensLength = stringTokens.length; i < stringTokensLength; i++) {
			result[i] = Integer.parseInt(stringTokens[i]);
		}
		return result;
	}
}
