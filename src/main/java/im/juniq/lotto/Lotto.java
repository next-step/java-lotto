package im.juniq.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	private static final int FIRST_LOTTO_NUMBER = 1;
	private static final int LAST_LOTTO_NUMBER = 45;
	private static final int NUMBER_OF_PICKUP = 6;
	private List<Integer> numbers;

	public Lotto() {
		List<Integer> baseNumbers = makeBaseNumbers();
		new ShuffleStrategyImpl().shuffle(baseNumbers);
		numbers = pickupNumbers(baseNumbers);
	}

	public Lotto(ShuffleStrategy shuffleStrategy) {
		List<Integer> baseNumbers = makeBaseNumbers();
		shuffleStrategy.shuffle(baseNumbers);
		numbers = pickupNumbers(baseNumbers);
	}

	public List<Integer> numbers() {
		return numbers;
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

	public int numberOfMatchedWinningNumber(List winningNumbers) {
		int matchedCount = 0;
		for (int number : numbers) {
			if (winningNumbers.contains(number)) {
				matchedCount++;
			}
		}
		return matchedCount;
	}
}
