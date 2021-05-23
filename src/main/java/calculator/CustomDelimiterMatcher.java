package calculator;

import static java.util.Objects.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CustomDelimiterMatcher {

	private final Matcher matcher;
	private final static Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	private CustomDelimiterMatcher(Matcher matcher) {
		requireNonNull(matcher);
		this.matcher = matcher;
	}

	public static String[] getSplitTokens(String userInput) {
		Matcher matcher = new CustomDelimiterMatcher(CUSTOM_DELIMITER_PATTERN.matcher(userInput)).matcher;
		if (matcher.find() == false) {
			throw new RuntimeException("커스텀 구분자를 찾을 수 없습니다");
		}
		String delimiter = matcher.group(1);
		String group = matcher.group(2);
		return group.split(delimiter);
	}
	
	public static boolean hasDelimiter(String userInput) {
		return CUSTOM_DELIMITER_PATTERN.asPredicate().test(userInput);
	}
}
