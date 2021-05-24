package lotto;

import java.util.List;

public class Lotto {

	private final List<Number> numbers;

	public Lotto(List<Number> numbers) {
		validateNumbers(numbers);

		this.numbers = numbers;
	}

	public int matchCount(List<Number> winningNumbers) {
		return numbers.stream()
			.mapToInt(number -> winningNumbers.contains(number) ? 1 : 0)
			.sum();
	}

	private void validateNumbers(List<Number> numbers) {
		long distinctCount = numbers.stream()
								.distinct()
								.count();

		if (numbers.size() != 6 || distinctCount != 6) {
			throw new IllegalArgumentException("Numbers must consist of 6 distinct numbers.");
		}
	}
}
