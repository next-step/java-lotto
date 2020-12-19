package edu.nextstep.lotto.domain.sub;

import java.math.BigDecimal;
import java.util.Map;

public class LottoGameResult {
	private final Map<LottoRank, Long> lottoGameResultMap;

	public LottoGameResult(Lottos soldLottos, Lotto winningLotto) {
		this.lottoGameResultMap = soldLottos.getResultAsCountingMap(winningLotto);
	}

	public BigDecimal getProfitRatio() {
		long soldLottoCount = getSoldLottoCount();
		if (soldLottoCount == 0L) {
			return BigDecimal.ONE;
		}
		BigDecimal profit = BigDecimal.valueOf(
			lottoGameResultMap.entrySet()
				.stream()
				.mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
				.sum()
		);
		BigDecimal usedMoney = BigDecimal.valueOf(soldLottoCount * Lotto.PRICE);
		return profit.divide(usedMoney, 2, BigDecimal.ROUND_DOWN);
	}

	public long getSoldLottoCount() {
		return lottoGameResultMap.values()
			.stream()
			.mapToLong(Long::longValue)
			.sum();
	}

	public Map<LottoRank, Long> getResultMap() {
		return lottoGameResultMap;
	}
}
