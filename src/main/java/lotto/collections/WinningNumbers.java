package lotto.collections;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoNumber;

public class WinningNumbers {

	final List<LottoNumber> winningNumbers;

	public WinningNumbers(List<Integer> winningNumberLists) {
		super();
		this.winningNumbers = createWinningNumbers(winningNumberLists);
	}

	private List<LottoNumber> createWinningNumbers(List<Integer> winningNumberLists) {
		validateSizeOfWinningNumbers(winningNumberLists);
		List<LottoNumber> numbers = new ArrayList<>();
		for (int number : winningNumberLists) {
			numbers.add(new LottoNumber(number));
		}
		return numbers;
	}

	private void validateSizeOfWinningNumbers(List<Integer> winningNumberLists) {
		if (winningNumberLists.size() != 6) {
			throw new RuntimeException("winning numbers should have only 6 elements.");
		}
	}

	public List<LottoNumber> getWinningNumbers() {
		return winningNumbers;
	}
}
