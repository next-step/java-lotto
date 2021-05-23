package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private static final int TWO_LOTTO_NUMBERS_LENGTH = Constants.LOTTO_NUMBERS_LENGTH * 2;
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != Constants.LOTTO_NUMBERS_LENGTH) {
			throw new InvalidLottoNumberLengthException();
		}

		if (Collections.min(numbers) < Constants.LOTTO_MIN_NUMBER || Collections.max(numbers) > Constants.LOTTO_MAX_NUMBER) {
			throw new InvalidLottoNumberException();
		}
	}

	public List<Integer> numbers() {
		return this.numbers;
	}

	public int checkWinning(List<Integer> winningNumber) {
		Set<Integer> set = new HashSet<>(winningNumber);
		set.addAll(this.numbers);
		return TWO_LOTTO_NUMBERS_LENGTH - set.size();
	}
}
