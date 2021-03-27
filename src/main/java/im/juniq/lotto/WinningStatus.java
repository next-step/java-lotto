package im.juniq.lotto;

import java.util.List;

public class WinningStatus {
	private Lottoes lottoes;
	private List<Integer> winningNumbers;
	private int countMatchedLotto = 0;

	public WinningStatus(Lottoes lottoes, List<Integer> winningNumbers) {
		this.lottoes = lottoes;
		this.winningNumbers = winningNumbers;
	}

	public int numberOfLottoesMatched(int count) {
		for (Lotto lotto : lottoes.get()) {
			countMatchedLottoes(count, lotto);
		}

		return countMatchedLotto;
	}

	private void countMatchedLottoes(int matchingCount, Lotto lotto) {
		if (lotto.numberOfMatchedWinningNumber(winningNumbers) == matchingCount) {
			countMatchedLotto++;
		}
	}
}
