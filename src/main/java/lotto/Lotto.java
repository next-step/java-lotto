package lotto;

import java.util.List;

public class Lotto {

	private final List<Number> numbers;

	public Lotto(List<Number> numbers) {
		validateNumbers(numbers);

		this.numbers = numbers;
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
