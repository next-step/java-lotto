package lotto.domain.strategy;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoGenerateStrategy implements GenerateStrategy{
	private static final Integer NUMBERS_COUNT = 6;
	@Override
	public Set<Integer> generate() {
		List<Integer> numbers
			= IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());
		Collections.shuffle(numbers);
		return Set.copyOf(numbers.subList(0, NUMBERS_COUNT));
	}
}
