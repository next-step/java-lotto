package step1.domain.collections;

import step1.domain.Number;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static step1.domain.Number.ZERO_NUMBER;

public class Numbers {

	private final List<Number> numbers;

	public Numbers(String input, Pattern delimiter) {
		this.numbers = toNumbers(input, delimiter);
	}

	public Numbers(List<Number> numbers) {
		this.numbers = numbers;
	}

	private List<Number> toNumbers(String input, Pattern delimiter) {
		return Arrays.stream(delimiter
				.split(input))
				.map(Number::new)
				.collect(Collectors.toList());
	}

	public Number sum() {
		return numbers.stream()
					.reduce(ZERO_NUMBER, Number::sum);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Numbers numbers1 = (Numbers) o;
		return numbers.equals(numbers1.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
