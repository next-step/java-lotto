package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberStrategy implements NumberStrategy {
	public static final int MIN_BOUND = 1;
	public static final int MAX_BOUND = 45;
	public static final int COUNT_NUMBER = 6;

	@Override
	public List<Integer> generateNumber() {
		List<Integer> numbers = IntStream.rangeClosed(MIN_BOUND, MAX_BOUND)
			.boxed()
			.collect(Collectors.toList());
		Collections.shuffle(numbers);
		return numbers.subList(0, COUNT_NUMBER);
	}
}
