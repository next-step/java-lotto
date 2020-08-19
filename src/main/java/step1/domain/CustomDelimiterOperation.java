package step1.domain;

import step1.domain.collections.Numbers;

import java.util.Objects;
import java.util.regex.Pattern;

import static step1.util.StringUtil.EMPTY_STRING;

public class CustomDelimiterOperation implements Operation {

	private static final Pattern USELESS_STRING_REGEX = Pattern.compile("//(.)\\\\n");

	private final Numbers numbers;

	public CustomDelimiterOperation(Pattern pattern, String input) {
		String necessary = USELESS_STRING_REGEX.matcher(input).replaceAll(EMPTY_STRING);
		this.numbers = new Numbers(necessary, pattern);
	}
	//For test
	public CustomDelimiterOperation(Numbers numbers) {
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
		CustomDelimiterOperation that = (CustomDelimiterOperation) o;
		return numbers.equals(that.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
