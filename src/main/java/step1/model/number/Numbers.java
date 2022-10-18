package step1.model.number;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
	private List<Number> numbers;

	public Numbers() {
	}

	public Numbers(List<Number> numbers) {
		this.numbers = numbers;
	}

	public Numbers convertToNumbers(List<String> strings) {
		return new Numbers(strings.stream()
			.map(Number::new)
			.collect(Collectors.toList()));
	}

	public Number get(int index) {
		return this.numbers.get(index);
	}
}
