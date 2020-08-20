package step2.domain;

import java.util.*;

public class LottoStatistic {
	private final List<Integer> winningNumbers;
	private static final Map<Integer, Integer> lottoStat = new HashMap<>();
	private static final int MIN_WINNING_COUNT = 3;
	private static final int MAX_WINNING_COUNT = 6;

	public LottoStatistic(Lotto winningLotto) {
		for (int i = MIN_WINNING_COUNT; i <= MAX_WINNING_COUNT; i++) {
			lottoStat.put(i, 0);
		}
		this.winningNumbers = winningLotto.getNumbers();
	}

	public Map<Integer, Integer> calcLottoResult(List<Lotto> lottoResult) {
		for (Lotto integers : lottoResult) {
			calcWinningNumberCount(integers);
		}
		return lottoStat;
	}

	private void calcWinningNumberCount(Lotto lotto) {
		int count = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();

		LottoWinning winning = LottoWinning.of(count);
		if (!winning.equals(LottoWinning.NOTTING)) {
			lottoStat.put(count, lottoStat.getOrDefault(count, 0)+1);
		}
	}

	public double calcYield(int price) {
		double sum = 0.0;
		for (Integer winningCount : lottoStat.keySet()) {
			LottoWinning winning = LottoWinning.of(winningCount);
			sum += winning.calcReward(lottoStat.get(winningCount));
		}
		return sum / price;
	}

}
