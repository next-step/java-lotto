package calculator;

import static java.util.Objects.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DelimiterMatcher {

	private final Matcher matcher;
	private boolean hasCustomDelimiter = false;

	private DelimiterMatcher(Matcher matcher) {
		requireNonNull(matcher);
		this.matcher = matcher;
	}

	public static DelimiterMatcher create(String userInput, Pattern compile) {
		return new DelimiterMatcher(compile.matcher(userInput));
	}

	public boolean hasCustomDelimiter() {
		hasCustomDelimiter = matcher.find();
		return hasCustomDelimiter;
	}

	public String[] getSplitTokens() {
		if (hasCustomDelimiter) {
			String group = matcher.group(2);
			return group.split(getDelimiter());
		}
		return new String[] {};
	}

	private String getDelimiter() {
		if (hasCustomDelimiter) {
			return matcher.group(1);
		}
		return "";
	}
}
