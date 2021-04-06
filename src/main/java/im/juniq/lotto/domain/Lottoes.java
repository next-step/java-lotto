package im.juniq.lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lottoes implements Iterable<Lotto> {
	private final List<Lotto> lottoes = new ArrayList<>();
	private final int autoLottoSize;
	private final int manualLottoSize;

	public Lottoes(int numberOfCreated, ShuffleStrategy shuffleStrategy) {
		this(numberOfCreated, shuffleStrategy, new ArrayList<>());
	}

	public Lottoes(int numberOfCreated,	ShuffleStrategy shuffleStrategy, List<LottoNumbers> manualLottoes) {
		manualLottoSize = manualLottoes.size();
		autoLottoSize = numberOfCreated - manualLottoes.size();
		makeLottoes(manualLottoes);
		makeLottoes(autoLottoSize, shuffleStrategy);
	}

	public Lottoes(Lotto... lotto) {
		lottoes.addAll(Arrays.asList(lotto));
		autoLottoSize = 0;
		manualLottoSize = 0;
	}

	public Lottoes(List<Lotto> lottoes) {
		this.lottoes.addAll(lottoes);
		autoLottoSize = 0;
		manualLottoSize = 0;
	}

	private List<Lotto> makeLottoes(int numberOfCreated, ShuffleStrategy shuffleStrategy) {
		for (int i = 0; i < numberOfCreated; i++) {
			lottoes.add(new Lotto(shuffleStrategy));
		}
		return lottoes;
	}

	private List<Lotto> makeLottoes(List<LottoNumbers> manualLottoes) {
		for (LottoNumbers lottoNumbers : manualLottoes) {
			lottoes.add(new Lotto(lottoNumbers));
		}
		return lottoes;
	}

	public Lotto lotto(int index) {
		return lottoes.get(index);
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

	public int autoLottoSize() {
		return autoLottoSize;
	}

	public int manualLottoSize() {
		return manualLottoSize;
	}

	@Override
	public Iterator<Lotto> iterator() {
		return lottoes.iterator();
	}
}
