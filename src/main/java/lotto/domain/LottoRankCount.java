package lotto.domain;

import java.util.Map;

public class LottoRankCount {

	Map<LottoRank, Long> rankCount;

	public LottoRankCount(Map<LottoRank, Long> rankCount) {
		this.rankCount = rankCount;
	}

	public long getCount(LottoRank lottoRank) {
		return this.rankCount.get(lottoRank);
	}

}
