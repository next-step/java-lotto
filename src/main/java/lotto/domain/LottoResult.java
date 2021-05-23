package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

	private static final int ROUND = 2;

	private final List<LottoRank> lottoRanks;

	public LottoResult(final List<LottoRank> lottoRanks) {
		this.lottoRanks = lottoRanks;
	}

	public long getTotalReward() {
		long totalReward = 0;
		for (LottoRank lottoRank : lottoRanks) {
			totalReward += lottoRank.getReward();
		}
		return totalReward;
	}

	public double getYield() {
		return new BigDecimal(getTotalReward()).divide(new BigDecimal(getLottoTotalCount() * Lotto.LOTTO_PRICE), ROUND,
			BigDecimal.ROUND_DOWN).doubleValue();
	}

	private int getLottoTotalCount() {
		return this.lottoRanks.size();
	}

	public LottoRankCount getLottoRankCount() {
		Map<LottoRank, Long> rankCount = new HashMap<>();
		Arrays.stream(LottoRank.values())
			.forEach(lottoRank -> {
				long count = this.lottoRanks.stream()
					.filter(resultLottoRank -> resultLottoRank == lottoRank)
					.count();
				rankCount.put(lottoRank, count);
			});
		return new LottoRankCount(rankCount);
	}

}
