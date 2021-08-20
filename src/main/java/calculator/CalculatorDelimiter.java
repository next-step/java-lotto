package calculator;

import java.util.Arrays;
import java.util.List;

public class CalculatorDelimiter {
	private final String delimiter;

	public CalculatorDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	public List<String> operate(String expression) {
		String[] result = expression.split(this.delimiter);
		return Arrays.asList(result);
	}
}
