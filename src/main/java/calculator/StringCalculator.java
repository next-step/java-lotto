package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

	private static final String DEFAULT_DELIMITER = ",|:";
	private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile(DEFAULT_DELIMITER);

	public static int sumByDelimiter(String text) {
		if (isEmpty(text)) {
			return 0;
		}
		if (!hasDelimiter(text, DEFAULT_DELIMITER_PATTERN)) {
			return Integer.parseInt(text);
		}
		String[] tokens = tokenizing(text);
		return sumTokens(tokens);
	}

	private static void validate(String token) {
		for (char ch : token.toCharArray()) {
			numberValidation(ch);
		}
	}

	private static void numberValidation(char ch) {
		if ('0' > ch || '9' < ch) {
			throw new RuntimeException("양수인 숫자만 연산이 가능합니다");
		}
	}

	private static int sumTokens(String[] tokens) {
		int result = 0;
		for (String token : tokens) {
			validate(token);
			result += Integer.parseInt(token);
		}
		return result;
	}

	private static String[] tokenizing(String text) {
		return tokenizing(text, DEFAULT_DELIMITER);
	}

	private static String[] tokenizing(String text, String delimiter) {
		return text.split(delimiter);
	}

	private static boolean hasDelimiter(String text, Pattern pattern) {
		return pattern.matcher(text).find();
	}

	private static boolean isEmpty(String text) {
		return text == null || text.isEmpty();
	}

}
