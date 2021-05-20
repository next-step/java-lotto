package study.step2.domain.service;

import java.util.List;

import study.step2.domain.value.Number;

public class StringAddCalculator {
	public static int sum(List<Number> numbers) {
		return numbers.stream()
			.mapToInt(Number::value)
			.reduce(0, (previousNumber, presentNumber) -> previousNumber + presentNumber);
	}
}
