package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerator {

	private final List<Integer> numbers;

	public RandomGenerator() {
		numbers = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			numbers.add(i);
		}
	}

	public List<Integer> generate() {
		Collections.shuffle(numbers);
		List<Integer> result = numbers.subList(0, 6);
		Collections.sort(result);
		return result;
	}
}
