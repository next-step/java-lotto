package step1;

import step1.domain.CustomDelimiterOperation;
import step1.domain.DefaultOperation;
import step1.domain.Operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static step1.domain.Number.ZERO;
import static step1.util.StringUtil.isNullOrEmpty;
import static step1.util.StringUtil.removeSpace;

public class StringAdder {

	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n((\\d\\1)*\\d)");

	private StringAdder() {}

	public static int calculate(String input) {
		if(isNullOrEmpty(input)) {
			return ZERO;
		}

		Operation operation = getOperation(removeSpace(input));

		return operation.sum();
	}

	private static Operation getOperation(String input) {
		if(isCustomDelimiterPattern(input)) {
			return new CustomDelimiterOperation(getCustomDelimiter(input), input);
		}

		return new DefaultOperation(input);
	}

	private static boolean isCustomDelimiterPattern(String input) {
		return CUSTOM_DELIMITER_PATTERN.matcher(input).matches();
	}

	private static Pattern getCustomDelimiter(String input) {
		return Pattern.compile(extractSpecificGroup(CUSTOM_DELIMITER_PATTERN.matcher(input),1));
	}

	private static String extractSpecificGroup(Matcher patternMatcher, int groupNumber) {
		String numbers = null;
		while (patternMatcher.find()) {
			numbers = patternMatcher.group(groupNumber);
		}
		return numbers;
	}
}
