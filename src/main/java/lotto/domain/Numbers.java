package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
	private final List<Number> numbers;

	public Numbers(List<Number> numbers) {
		this.numbers = numbers;
	}

	public boolean containsNumber(int number) {
		return getNumberValues().contains(number);
	}

	public int matchSize(Numbers numbers) {
		List<Integer> numberValues = numbers.getNumberValues();
		numberValues.retainAll(getNumberValues());
		return numberValues.size();
	}

	private List<Integer> getNumberValues() {
		return numbers.stream()
			.map(Number::getValue)
			.sorted()
			.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return getNumberValues().toString();
	}
}
