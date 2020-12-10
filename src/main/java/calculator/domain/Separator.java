package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
	private static final Pattern CUSTOM_SPLIT_PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final String SIMPLE_SPLIT_PATTERN = ",|:";
	public static final int MATCH_TEXT_INDEX = 2;
	public static final int MATCH_DIVIDER_INDEX = 1;

	private final String inputText;
	private final Matcher inputTextMatcher;

	public Separator(String inputText) {
		this.inputText = inputText;
		this.inputTextMatcher = getMatcher(inputText);
	}

	public List<String> getSeparatedText() {
		if (isValidation()) {
			return split(this.ofMatcherGroup(MATCH_TEXT_INDEX), this.ofMatcherGroup(MATCH_DIVIDER_INDEX));
		}
		return split(this.inputText, SIMPLE_SPLIT_PATTERN);
	}

	private List<String> split(String text, String divider) {
		return Arrays.asList(text.split(divider));
	}

	private boolean isValidation() {
		return this.inputTextMatcher.find();
	}

	private Matcher getMatcher(String inputText) {
		return CUSTOM_SPLIT_PATTERN.matcher(inputText);
	}

	private String ofMatcherGroup(int index) {
		return this.inputTextMatcher.group(index);
	}
}
