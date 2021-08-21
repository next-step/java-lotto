package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CalculatorDelimiter {
	private final String delimiter;

	public CalculatorDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	public List<String> operate(String expression) {
		String[] result = expression.split(this.delimiter);
		return Arrays.asList(result);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CalculatorDelimiter delimiter1 = (CalculatorDelimiter)o;
		return Objects.equals(delimiter, delimiter1.delimiter);
	}

	@Override
	public int hashCode() {
		return Objects.hash(delimiter);
	}
}
