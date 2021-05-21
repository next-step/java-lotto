package wootecam.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomStringTokenizer implements StringTokenizer {
	private static final String CUSTOM_PATTERN_REGEX = "\\/\\/(.)\\\\n(.*)";

	private static final Pattern pattern = Pattern.compile(CUSTOM_PATTERN_REGEX);

	@Override
	public List<String> getNumbers(String input) {
		Matcher matcher = pattern.matcher(input);

		if (!matcher.find()) {
			throw new RuntimeException("입력 패턴을 확인하세요.");
		}

		String customDelimiter = matcher.group(1);
		return Arrays.asList(matcher.group(2).split(customDelimiter));
	}

	@Override
	public boolean supportForTokenizing(String input) {
		return input.startsWith("//");
	}
}
