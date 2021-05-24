package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

	private static final String DEFAULT_DELIMITER = ",|:";
	private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

	private String tokenizer;
	private String text;

	public Tokenizer(Input input) {
		this.tokenizer = getTokenizer(input.getText());
		this.text = getWithOutTokenizerText(input.getText());
	}

	public String[] split() {
		return text.split(tokenizer);
	}

	private String getTokenizer(String input) {
		Matcher m = patternMatcher(input);
		if(!m.find()) {
			return DEFAULT_DELIMITER;
		}

		return m.group(1);
	}

	private String getWithOutTokenizerText(String input) {
		Matcher m = patternMatcher(input);
		if(!m.find()) {
			return input;
		}

		return m.group(2);
	}

	private Matcher patternMatcher(String input) {
		return CUSTOM_DELIMITER_PATTERN.matcher(input);
	}
}
