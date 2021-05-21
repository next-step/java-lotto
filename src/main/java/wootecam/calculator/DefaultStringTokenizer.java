package wootecam.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DefaultStringTokenizer implements StringTokenizer {

	private static final String SEPARATOR = "[,:]";
	private static final String DEFAULT_REGEX = "^([0-9]+)([,|:]([0-9]+))*";

	private static final Pattern pattern = Pattern.compile(DEFAULT_REGEX);

	@Override
	public List<String> getNumbers(String input) {
		return Arrays.asList(input.split(SEPARATOR));
	}

	@Override
	public boolean supportForTokenizing(String input) {
		return pattern.matcher(input).find();
	}
}
