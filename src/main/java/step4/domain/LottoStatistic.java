package step4.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistic {
	private final Map<Rank, Integer> lottoResultMap;
	private BigDecimal yield;

	private static final String INIT_SUM = "0";
	private static final int SCALE = 2;

	public LottoStatistic() {
		lottoResultMap = new EnumMap<>(Rank.class);
		yield = new BigDecimal(INIT_SUM);
	}

	public Map<Rank, Integer> calcLottoResult(List<Lotto> issueLottos, WinningLotto winningLotto) {
		int count;
		boolean isBonus;
		Rank rank;
		for (Lotto issueLotto : issueLottos) {
			count = issueLotto.getMatchCount(winningLotto.getWinningNumbers());
			isBonus = (count == Rank.FIVE.getMatchingCount() && issueLotto.containNumber(winningLotto.getBonusNumber()));
			rank = Rank.valueOf(count, isBonus);
			lottoResultMap.put(rank, lottoResultMap.getOrDefault(rank, 0)+1);
		}
		return lottoResultMap;
	}

	public BigDecimal calcYield(int price) {
		for (Rank winning : lottoResultMap.keySet()) {
			yield = yield.add(BigDecimal.valueOf(lottoResultMap.get(winning) * winning.getReward()));
		}
		return yield.divide(BigDecimal.valueOf(price), SCALE, RoundingMode.HALF_EVEN);
	}

}
