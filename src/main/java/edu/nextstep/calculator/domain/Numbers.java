package edu.nextstep.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
	private final List<Number> numbers;

	public Numbers(String[] textSplitResult) {
		this.numbers = Arrays.stream(textSplitResult)
			.map(Number::createFromString)
			.collect(Collectors.toList());
	}

	public int sumAll() {
		Number result = numbers.stream()
			.reduce(Number.createFromInteger(0), Number::sum);
		return result.getValue();
	}
}