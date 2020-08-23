package step3.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistic {
	private final Lotto winningLotto;
	private final int winningBonus;
	private static final Map<LottoWinning, Integer> lottoStat = new HashMap<>();
	private static final String INIT_SUM = "0";
	private static final int SCALE = 2;

	public LottoStatistic(Lotto winningLotto, int winningBonus) {
		this.winningLotto = winningLotto;
		this.winningBonus = winningBonus;
	}

	public Map<LottoWinning, Integer> calcLottoResult(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			calcWinningNumberCount(lotto);
		}
		return lottoStat;
	}

	private void calcWinningNumberCount(Lotto lotto) {
		int count = lotto.getMatchCount(winningLotto);
		LottoWinning winning = LottoWinning.valueOf(count, checkBonus(lotto));
		lottoStat.put(winning, lottoStat.getOrDefault(winning, 0)+1);
	}

	private boolean checkBonus(Lotto lotto) {
		int count = lotto.getMatchCount(winningLotto);
		return count == LottoWinning.FIVE.getMatchingCount() && lotto.containNumber(new LottoNumber(winningBonus));
	}

	public BigDecimal calcYield(int price) {
		BigDecimal sum = new BigDecimal(INIT_SUM);
		for (LottoWinning winning : lottoStat.keySet()) {
			int s = lottoStat.get(winning) * winning.getReward();
			sum = sum.add(BigDecimal.valueOf(s));
		}
		return sum.divide(BigDecimal.valueOf(price), SCALE, RoundingMode.HALF_EVEN);
	}

}
