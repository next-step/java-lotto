package lotto;

import java.util.List;

public class LottoWinningNumbers {
	private final List<Integer> lottoWinningNumbers;

	public LottoWinningNumbers(List<Integer> lottoWinningNumbers) {
		this.lottoWinningNumbers = lottoWinningNumbers;
	}

	public boolean isSame(List<Integer> numbers) {
		return this.lottoWinningNumbers == numbers;
	}
}
