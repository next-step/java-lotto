package lotto.domain;

import java.util.List;

public class Lotto {
	private final List<Number> numbers;

	public Lotto(List<Number> numbers) {
		this.numbers = numbers;
	}

	public List<Number> getNumbers() {
		return numbers;
	}
}
