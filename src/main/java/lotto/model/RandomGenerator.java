package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerator {

	private final List<Integer> numbers;
	private final static int LOW_BOUND = 1;
	private final static int MAX_BOUND = 45;

	public RandomGenerator() {
		numbers = new ArrayList<>();
		for (int number = LOW_BOUND; number <= MAX_BOUND; number++) {
			numbers.add(number);
		}
	}

	public List<Integer> generate() {
		Collections.shuffle(numbers);
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			result.add(numbers.get(i));
		}
		Collections.sort(result);
		return result;
	}
}
