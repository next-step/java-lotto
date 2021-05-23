package calculator;

import static calculator.StringUtils.*;

public final class AddCalculatorModel {
	private final static String DEFAULT_DELIMITER_REGEX = ",|:";
	private long sum = 0L;

	public long execute(String userInput) {
		if (isBlank(userInput)) {
			return sum;
		}

		if (CustomDelimiterMatcher.hasDelimiter(userInput)) {
			String[] splitTokens = CustomDelimiterMatcher.getSplitTokens(userInput);
			return calculate(StringUtils.convertStringToLong(splitTokens));
		}
		return calculate(StringUtils.convertStringToLong(userInput.split(DEFAULT_DELIMITER_REGEX)));
	}

	private long calculate(Long[] longs) {
		for (Long l : longs) {
			this.sum += l;
		}
		return sum;
	}
}
