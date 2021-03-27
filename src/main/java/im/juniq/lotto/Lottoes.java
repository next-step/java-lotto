package im.juniq.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottoes {
	private List<Lotto> lottoes = new ArrayList<>();

	public Lottoes(int numberOfCreated, ShuffleStrategy shuffleStrategy) {
		makeLottoes(numberOfCreated, shuffleStrategy);
	}

	public Lottoes(Lotto... lotto) {
		lottoes.addAll(Arrays.asList(lotto));
	}

	public Lottoes(List<Lotto> lottoes) {
		this.lottoes.addAll(lottoes);
	}

	private List<Lotto> makeLottoes(int numberOfCreated, ShuffleStrategy shuffleStrategy) {
		for (int i = 0; i < numberOfCreated; i++) {
			lottoes.add(new Lotto(shuffleStrategy));
		}
		return lottoes;
	}

	public Lotto lotto(int index) {
		return lottoes.get(index);
	}

	public int numberOfLottoesMatched(int count, WinningNumbers winningNumbers) {
		int countMatchedLotto = 0;
		for (Lotto lotto : lottoes) {
			countMatchedLotto += countMatchedLottoes(count, lotto, winningNumbers);
		}

		return countMatchedLotto;
	}

	private int countMatchedLottoes(int matchingCount, Lotto lotto, WinningNumbers winningNumbers) {
		if (lotto.numberOfMatchedWinningNumber(winningNumbers) == matchingCount) {
			return 1;
		}
		return 0;
	}
}
