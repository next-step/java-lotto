package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number {
	private static final String POSITIVE_NUMBER_REGX = "(^[0-9]*$)";
	private int value;

	public Number(String value) {
		validatePositiveNumber(value);
		this.value = Integer.parseInt(value);
	}

	public int getValue() {
		return value;
	}

	public void validatePositiveNumber(String value) {
		Pattern pattern = Pattern.compile(POSITIVE_NUMBER_REGX);
		Matcher matcher = pattern.matcher(value);

		if (!matcher.find()) {
			throw new RuntimeException();
		}
	}
}
