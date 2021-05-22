package study.step2.domain.service;

import java.util.List;

import study.step2.domain.value.Number;

public class StringAddCalculator {
	private static final int RETURN_ZERO = 0;

	public static int sum(List<Number> numbers) {
		return numbers.stream()
			.mapToInt(Number::value)
			.reduce(RETURN_ZERO, (previousNumber, presentNumber) -> previousNumber + presentNumber);
	}
}
