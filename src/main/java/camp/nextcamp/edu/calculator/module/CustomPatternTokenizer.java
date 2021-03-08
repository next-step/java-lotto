package camp.nextcamp.edu.calculator.module;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomPatternTokenizer extends PatternStringTokenizer {
	public CustomPatternTokenizer() {
		super("\\/\\/(.)\\\\n(.*)");
	}

	@Override
	public List<String> makeListByPatternSplit(String input) {
		Matcher matcher = getMatcher(input);
		if (!matcher.find()) {
			throw new RuntimeException("맞는 패턴이 없습니다.");
		}

		String customDelimiter = getCustomDelimiter(matcher);
		return getListByDelimiter(matcher, customDelimiter);
	}

	private List<String> getListByDelimiter(Matcher matcher, String customDelimiter) {
		return Arrays.asList(matcher.group(2).split(customDelimiter));
	}

	private Matcher getMatcher(String input) {
		return Pattern.compile(super.getRegex()).matcher(input);
	}

	private String getCustomDelimiter(Matcher matcher) {
		return matcher.group(1);
	}
}
