package im.juniq.lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lottoes implements Iterable<Lotto> {
	private final List<Lotto> lottoes = new ArrayList<>();

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
		return lottoes.stream().mapToInt(lotto -> countMatchedLottoes(winning, lotto, winningNumbers)).sum();
	}

	private int countMatchedLottoes(Winning winning, Lotto lotto, WinningNumbers winningNumbers) {
		if (lotto.winning(winningNumbers) == winning) {
			return 1;
		}
		return 0;
	}

	public double yield(WinningNumbers winningNumbers, Price price) {
		return price.yield((double) totalPrize(winningNumbers));
	}

	private long totalPrize(WinningNumbers winningNumbers) {
		return lottoes.stream().mapToLong(lotto -> lotto.prize(winningNumbers)).sum();
	}

	@Override
	public Iterator<Lotto> iterator() {
		return lottoes.iterator();
	}
}
