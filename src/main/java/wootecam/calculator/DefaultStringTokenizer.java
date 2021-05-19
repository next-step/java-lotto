package wootecam.calculator;

import java.util.Arrays;
import java.util.List;

public class DefaultStringTokenizer {

	private static final String SEPARATOR = "[,:]";

	public List<String> getNumbers(String input) {
		return Arrays.asList(input.split(SEPARATOR));
	}
}
