package lotto;

import java.util.List;

public class Lotto {

	private static final int REQUIRED_COUNT = 6;

	private final List<Number> numbers;

	public Lotto(List<Number> numbers) {
		validateNumbers(numbers);

		this.numbers = numbers;
	}

	public long matchCount(List<Number> winningNumbers) {
		return numbers.stream()
			.filter(winningNumbers::contains)
			.count();
	}

	private void validateNumbers(List<Number> numbers) {
		long distinctCount = numbers.stream()
								.distinct()
								.count();

		if (numbers.size() != REQUIRED_COUNT || distinctCount != REQUIRED_COUNT) {
			throw new IllegalArgumentException("Numbers must consist of 6 distinct numbers.");
		}
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
