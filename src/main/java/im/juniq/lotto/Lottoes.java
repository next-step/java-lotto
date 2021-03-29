package im.juniq.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lottoes implements Iterable<Lotto>{
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

	public int size() {
		return lottoes.size();
	}

	public int numberOfLottoesMatched(int count, WinningNumbers winningNumbers) {
		int countMatchedLotto = 0;
		for (Lotto lotto : lottoes) {
			countMatchedLotto += countMatchedLottoes(count, lotto, winningNumbers);
		}
		return countMatchedLotto;
	}

	private int countMatchedLottoes(int matchingCount, Lotto lotto, WinningNumbers winningNumbers) {
		if (lotto.winning(winningNumbers).matchedCount() == matchingCount) {
			return 1;
		}
		return 0;
	}

	public double yield(WinningNumbers winningNumbers, Price price) {
		double winningAmount = 0;
		winningAmount += Winning.FIRST.amount() * numberOfLottoesMatched(6, winningNumbers);
		winningAmount += Winning.SECOND.amount() * numberOfLottoesMatched(5, winningNumbers);
		winningAmount += Winning.THIRD.amount() * numberOfLottoesMatched(4, winningNumbers);
		winningAmount += Winning.FOURTH.amount() * numberOfLottoesMatched(3, winningNumbers);

		return price.yield(winningAmount);
	}

	@Override
	public Iterator<Lotto> iterator() {
		return lottoes.iterator();
	}
}
