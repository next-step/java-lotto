package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRankCount {

	private static final int INIT_COUNT = 0;
	private static final int ADD_COUNT = 1;

	private Map<LottoRank, Integer> rankCount;

	public LottoRankCount(List<LottoRank> lottoRanks) {
		initRankCount();
		calculateLottoRanksCount(lottoRanks);
	}

	public long getCount(LottoRank lottoRank) {
		return this.rankCount.get(lottoRank);
	}

	private void initRankCount() {
		this.rankCount = new EnumMap<>(LottoRank.class);
		for (LottoRank lottoRank : LottoRank.values()) {
			this.rankCount.put(lottoRank, INIT_COUNT);
		}
	}

	private void calculateLottoRanksCount(List<LottoRank> lottoRanks) {
		lottoRanks.forEach(this::addLottoRankCount);
	}

	private void addLottoRankCount(LottoRank lottoRank) {
		this.rankCount.put(lottoRank, this.rankCount.get(lottoRank) + ADD_COUNT);
	}
}
