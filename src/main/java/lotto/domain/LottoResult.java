package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

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
		return new LottoRankCount(this.lottoRanks);
	}

}
