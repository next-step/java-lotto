package kht2199;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kht2199.exception.CannotFoundPatternException;

@SuppressWarnings("SameParameterValue")
public class StringAddCalculator {

	private static final String DELIMITER_REGEX = "[,:]";

	private static final Pattern DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int splitAndSum(String text) {
		if (!checkValidationInputText(text)) {
			return 0;
		}

		String[] tokens;
		try {
			tokens = parseTextByMatcher(DELIMITER_PATTERN, text);
		} catch (CannotFoundPatternException e) {
			tokens = text.split(DELIMITER_REGEX);
		}

		int[] intTokens = stringToInt(tokens);
		for (int token : intTokens) {
			checkValidationToken(token);
		}

		return accumulate(intTokens);
	}

	private static String[] parseTextByMatcher(Pattern pattern, String text) throws CannotFoundPatternException {
		Matcher matcher = pattern.matcher(text);
		if (!matcher.find()) {
			throw new CannotFoundPatternException();
		}
		checkValidationMatcherGroupCount(matcher);
		return matcher.group(2).split(matcher.group(1));
	}

	private static void checkValidationMatcherGroupCount(Matcher matcher) {
		int groupCount = matcher.groupCount();
		if (groupCount != 2) {
			throw new RuntimeException("invalid group count. " + groupCount);
		}
	}

	private static int accumulate(int[] values) {
		int sum = 0;
		for (int integer : values) {
			sum += integer;
		}
		return sum;
	}

	/**
	 *
	 * @param token 토큰
	 * @throws RuntimeException token 검증 실패시 발생.
	 */
	private static void checkValidationToken(int token) throws RuntimeException {
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

	private static int[] stringToInt(String[] string) {
		int[] result = new int[string.length];
		for (int index = 0; index < string.length; index++) {
			result[index] = Integer.parseInt(string[index]);
		}
		return result;
	}
}
