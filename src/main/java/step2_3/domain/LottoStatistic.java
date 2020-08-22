package step2_3.domain;

import java.util.*;

public class LottoStatistic {
	private final Lotto winningLotto;
	private final Integer winningBonus;
	private static final Map<LottoWinning, Integer> lottoStat = new HashMap<>();

	public LottoStatistic(Lotto winningLotto, Integer winningBonus) {
		this.winningLotto = winningLotto;
		this.winningBonus = winningBonus;
	}

	public Map<LottoWinning, Integer> calcLottoResult(List<Lotto> lottoResult) {
		for (Lotto integers : lottoResult) {
			calcWinningNumberCount(integers);
		}
		return lottoStat;
	}

	private void calcWinningNumberCount(Lotto lotto) {
		int count = (int) lotto.getNumbers().stream().filter(winningLotto.getNumbers()::contains).count();

		LottoWinning winning = LottoWinning.valueOf(count, count == LottoWinning.BONUS.getMatchingCount() && checkBonus(lotto));
		lottoStat.put(winning, lottoStat.getOrDefault(winning, 0)+1);
	}

	private boolean checkBonus(Lotto lotto) {
		Optional<Integer> maybeBonus = lotto.getNumbers().stream().filter(number -> !winningLotto.getNumbers().contains(number)).findFirst();
		if(maybeBonus.isPresent()) {
			Integer bonus = maybeBonus.get();
			return winningBonus.equals(bonus);
		}
		return false;
	}

	public double calcYield(int price) {
		double sum = 0.0;
		for (LottoWinning winning : lottoStat.keySet()) {
			sum += winning.calcReward(lottoStat.get(winning));
		}
		return sum / price;
	}

}
