package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
	private static final int DEFAULT_COUNT = 0;
	private static final int COUNT_INCREMENT_UNIT = 1;
	private final Map<LottoRank, Integer> countByLottoRank;

	LottoResult() {
		countByLottoRank = new HashMap<>();
	}

	public int count(LottoRank rank) {
		return countByLottoRank.getOrDefault(rank, DEFAULT_COUNT);
	}

	void increaseCountOfRank(LottoRank lottoRank) {
		countByLottoRank.put(lottoRank, count(lottoRank) + COUNT_INCREMENT_UNIT);
	}

	Money sumTotalPrize() {
		Money totalPrize = Money.ZERO_WONS;
		for (LottoRank lottoRank : countByLottoRank.keySet()) {
			Money prizeOfLank = lottoRank.multiplyPrize(count(lottoRank));
			totalPrize = totalPrize.plus(prizeOfLank);
		}
		return totalPrize;
	}

	public Rate calculateEarningRate(Money capital) {
		double earningRate = sumTotalPrize().divided(capital);
		return Rate.of(earningRate);
	}
}
