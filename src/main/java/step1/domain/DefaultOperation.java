package step1.domain;

import step1.domain.collections.Numbers;

import java.util.Objects;
import java.util.regex.Pattern;

public class DefaultOperation implements Operation{

	private static final Pattern DEFAULT_DELIMITER = Pattern.compile("[,:]");

	private final Numbers numbers;

	public DefaultOperation(String input) {
		this.numbers = new Numbers(input, DEFAULT_DELIMITER);
	}
	//For Test
	public DefaultOperation(Numbers numbers) {
		this.numbers = numbers;
	}

	@Override
	public int sum() {
		return numbers.sum()
						.intValue();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DefaultOperation that = (DefaultOperation) o;
		return numbers.equals(that.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
