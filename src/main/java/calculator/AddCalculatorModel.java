package calculator;

import static calculator.NumberUtils.*;
import static calculator.StringUtils.*;

import java.util.regex.Pattern;

public final class AddCalculatorModel {
	private final static String DEFAULT_DELIMITER_REGEX = ",|:";
	private final static String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

	private final String userInput;

	private long sum = 0L;

	public AddCalculatorModel(String userInput) {
		this.userInput = userInput;
	}

	public String userInput() {
		return userInput;
	}

	public long execute() {
		if (isBlank(userInput())) {
			return 0L;
		}

		DelimiterMatcher matcher = DelimiterMatcher.create(userInput(), Pattern.compile(CUSTOM_DELIMITER_REGEX));

		if (matcher.hasCustomDelimiter()) {
			return calculate(requireNumber(matcher.getSplitTokens()));
		}
		return calculate(getSplit(requireNumber(userInput()), DEFAULT_DELIMITER_REGEX));
	}

	private long calculate(String[] strings) {
		for (String s : strings) {
			this.sum += Long.parseLong(s);
		}
		return sum;
	}
}
