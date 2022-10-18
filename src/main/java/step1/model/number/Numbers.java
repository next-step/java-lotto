package step1.model.number;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Numbers implements Iterable<Number>{
	private List<Number> numbers;

	public Numbers() {
	}

	public Numbers(List<Number> numbers) {
		this.numbers = numbers;
	}

	public Numbers convertToNumbers(List<String> strings) {
		return new Numbers(strings.stream()
			.filter(string -> strings.indexOf(string) % 2 == 0)
			.map(Number::new)
			.collect(Collectors.toList()));
	}

	public Number get(int index) {
		return this.numbers.get(index);
	}

	@Override
	public Iterator<Number> iterator() {
		return numbers.iterator();
	}

	@Override
	public void forEach(Consumer<? super Number> action) {
		Iterable.super.forEach(action);
	}
}
