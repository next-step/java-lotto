package im.juniq.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	private static final int FIRST_LOTTO_NUMBER = 1;
	private static final int LAST_LOTTO_NUMBER = 45;
	private static final int NUMBER_OF_PICKUP = 6;
	private final List<Integer> numbers;

	public Lotto() {
		List<Integer> baseNumbers = makeBaseNumbers();
		new NormalShuffleStrategy().shuffle(baseNumbers);
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

	public Winning winning(WinningNumbers winningNumbers) {
		return Winning
				.findByMatchedCount(numberOfMatchedWinningNumber(winningNumbers), matchedBonusNumber(winningNumbers));
	}

	private int numberOfMatchedWinningNumber(WinningNumbers winningNumbers) {
		return numbers.stream().mapToInt(number -> countMatched(winningNumbers, number)).sum();
	}

	private int countMatched(WinningNumbers winningNumbers, int number) {
		if (winningNumbers.existent(number)) {
			return 1;
		}
		return 0;
	}

	private boolean matchedBonusNumber(WinningNumbers winningNumbers) {
		int sum = numbers.stream().mapToInt(number -> countMatchedBonusNumber(winningNumbers, number)).sum();
		return sum != 0;
	}

	private int countMatchedBonusNumber(WinningNumbers winningNumbers, int number) {
		if (winningNumbers.matchedBonusNumber(number)) {
			return 1;
		}
		return 0;
	}

	public long prize(WinningNumbers winningNumbers) {
		return winning(winningNumbers).amount();
	}
}
