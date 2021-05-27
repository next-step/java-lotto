package lotto;

import lotto.exceptions.InvalidLottoNumberException;
import lotto.exceptions.InvalidLottoNumberLengthException;

import java.util.Collections;
import java.util.List;

public class Lotto {
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

	public LottoPrizeType checkWinning(WinningNumber winningNumber) {
		return winningNumber.checkWinning(numbers);
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
