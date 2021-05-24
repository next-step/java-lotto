package lotto.model;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoResult {
	private static final int DEFAULT_COUNT = 0;
	private static final int COUNT_INCREMENT_UNIT = 1;
	private final Map<LottoRank, Integer> countByLottoRank;

	private LottoResult(Map<LottoRank, Integer> countByLottoRank) {
		this.countByLottoRank = Collections.unmodifiableMap(countByLottoRank);
	}

	static LottoResult of(List<LottoRank> lottoRanks) {
		Map<LottoRank, Integer> countByLottoRank = lottoRanks.stream()
			.collect(toMap(rank -> rank, rank -> COUNT_INCREMENT_UNIT, Integer::sum));
		return new LottoResult(countByLottoRank);
	}

	public int count(LottoRank rank) {
		return countByLottoRank.getOrDefault(rank, DEFAULT_COUNT);
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
