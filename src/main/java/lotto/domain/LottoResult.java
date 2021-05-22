package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class LottoResult {

	private static final int ROUND = 2;

	private final List<LottoRank> lottoRanks;

	public LottoResult(final List<LottoRank> lottoRanks) {
		this.lottoRanks = lottoRanks;
	}

	public int getTotalReward() {
		int totalReward = 0;
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
		long firstCount = this.lottoRanks.stream().filter(lottoRank -> lottoRank == LottoRank.FIRST).count();
		long secondCount = this.lottoRanks.stream().filter(lottoRank -> lottoRank == LottoRank.SECOND).count();
		long thirdCount = this.lottoRanks.stream().filter(lottoRank -> lottoRank == LottoRank.THIRD).count();
		long fourthCount = this.lottoRanks.stream().filter(lottoRank -> lottoRank == LottoRank.FOURTH).count();
		return new LottoRankCount(firstCount, secondCount, thirdCount, fourthCount);
	}

}
