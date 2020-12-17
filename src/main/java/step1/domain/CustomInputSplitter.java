package step1.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomInputSplitter extends NumberInputSplitter {

	@Override
	protected String[] doSplit(final String input) {
		Pattern pattern = InputSplitterFactory.CUSTOM_SPLITTER.getPattern();
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
		}
		throw new RuntimeException("커스텀 구분자로 패턴을 찾을 수 없습니다.");
	}

}
