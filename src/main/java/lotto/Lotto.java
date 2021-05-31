package lotto;

import lotto.exceptions.InvalidLottoNumberException;
import lotto.exceptions.InvalidLottoNumberLengthException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		Set<Integer> numbersSet = new HashSet<>(numbers);
		validate(numbersSet);
		this.numbers = numbers;
	}

	private void validate(Set<Integer> numbers) {
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

	public LottoPrizeType checkWinning(WinningNumber winningNumber) {
		return winningNumber.checkWinning(numbers);
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
