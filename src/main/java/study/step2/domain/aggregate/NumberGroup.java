package study.step2.domain.aggregate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import study.step2.domain.value.Number;

public class NumberGroup {
	private final List<Number> numbers;

	private NumberGroup(List<Number> numbers) {
		this.numbers = numbers;
	}

	public static NumberGroup generate(String[] splitStrings) {
		return new NumberGroup(parse(splitStrings));
	}

	private static List<Number> parse(String[] splitStrings) {
		return Arrays.stream(splitStrings)
			.map(Number::generate)
			.collect(Collectors.toList());
	}

	public List<Number> numbers() {
		return Collections.unmodifiableList(this.numbers);
	}
}
