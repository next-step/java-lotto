package im.juniq.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	private static final int FIRST_LOTTO_NUMBER = 1;
	private static final int LAST_LOTTO_NUMBER = 45;
	private static final int NUMBER_OF_PICKUP = 6;

	public List<Integer> numbers() {
		List<Integer> baseNumbers = makeBaseNumbers();
		Collections.shuffle(baseNumbers);
		return pickupNumbers(baseNumbers);
	}

	private List<Integer> makeBaseNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = FIRST_LOTTO_NUMBER; i <= LAST_LOTTO_NUMBER; i++) {
			numbers.add(i);
		}
		return numbers;
	}

	private List<Integer> pickupNumbers(List<Integer> baseNumbers) {
		List<Integer> results = baseNumbers.subList(0, NUMBER_OF_PICKUP);
		Collections.sort(results);
		return results;
	}
}
