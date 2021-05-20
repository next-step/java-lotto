package wootecam.calculator;

import java.util.Arrays;
import java.util.List;

public class DefaultStringTokenizer implements StringTokenizer {

	private static final String SEPARATOR = "[,:]";

	@Override
	public List<String> getNumbers(String input) {
		return Arrays.asList(input.split(SEPARATOR));
	}

	@Override
	public boolean supportForTokenizing(String input) {
		return true;
	}
}
