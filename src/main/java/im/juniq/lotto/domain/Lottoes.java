package im.juniq.lotto.domain;

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

	public int numberOfLottoesMatched(Winning winning, WinningNumbers winningNumbers) {
		int countMatchedLotto = 0;
		for (Lotto lotto : lottoes) {
			countMatchedLotto += countMatchedLottoes(winning, lotto, winningNumbers);
		}
		return countMatchedLotto;
	}

	private int countMatchedLottoes(Winning winning, Lotto lotto, WinningNumbers winningNumbers) {
		if (lotto.winning(winningNumbers) == winning) {
			return 1;
		}
		return 0;
	}

	public double yield(WinningNumbers winningNumbers, Price price) {
		double winningAmount = 0;
		winningAmount += Winning.FIRST.amount() * numberOfLottoesMatched(Winning.FIRST, winningNumbers);
		winningAmount += Winning.SECOND.amount() * numberOfLottoesMatched(Winning.SECOND, winningNumbers);
		winningAmount += Winning.THIRD.amount() * numberOfLottoesMatched(Winning.THIRD, winningNumbers);
		winningAmount += Winning.FOURTH.amount() * numberOfLottoesMatched(Winning.FOURTH, winningNumbers);
		winningAmount += Winning.FIFTH.amount() * numberOfLottoesMatched(Winning.FIFTH, winningNumbers);

		return price.yield(winningAmount);
	}

	@Override
	public Iterator<Lotto> iterator() {
		return lottoes.iterator();
	}
}
