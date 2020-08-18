package step2;

import java.util.*;

public class LottoStatistic {
	private final List<Integer> winningNumbers;
	private static final Map<Integer, Integer> lottoStat = new HashMap<>();
	private static final int MIN_WINNING_COUNT = 3;
	private static final int MAX_WINNING_COUNT = 6;

	public LottoStatistic(List<Integer> winningNumbers) {
		for (int i = MIN_WINNING_COUNT; i <= MAX_WINNING_COUNT; i++) {
			lottoStat.put(i, 0);
		}
		this.winningNumbers = winningNumbers;
	}

	public Map<Integer, Integer> calcLottoResult(List<Integer[]> lottoResult) {
		for (Integer[] integers : lottoResult) {
			calcWinningNumberCount(integers);
		}
		return lottoStat;
	}

	private void calcWinningNumberCount(Integer[] lotto) {
		int count = (int) Arrays.stream(lotto).filter(winningNumbers::contains).count();
		
		LottoWinning winning = LottoWinning.of(count);
		if (!Objects.isNull(winning)) {
			lottoStat.put(count, lottoStat.getOrDefault(count, 0)+1);
		}
	}

	public int calcWinningsSum() {
		int sum = 0;
		for (Integer winningCount : lottoStat.keySet()) {
			LottoWinning winning = LottoWinning.of(winningCount);
			sum += winning.calcReward(lottoStat.get(winningCount));
		}
		return sum;
	}

}
