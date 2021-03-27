package im.juniq.lotto;

import java.util.List;

public class WinningStatus {
	private List<Lotto> lottoes;
	private List<Integer> winningNumbers;

	public WinningStatus(List<Lotto> lottoes, List<Integer> winningNumbers) {
		this.lottoes = lottoes;
		this.winningNumbers = winningNumbers;
	}

	public int numberOfLottoesMatched(int number) {
		int countMatchedLotto = 0;
		for (Lotto lotto : lottoes) {
			if (number == lotto.numberOfMatchedWinningNumber(winningNumbers)) {
				countMatchedLotto++;
			}
		}

		return countMatchedLotto;
	}
}
