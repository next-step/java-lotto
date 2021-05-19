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

	void add(int matchCount) {
		LottoRank lottoRank = LottoRank.of(matchCount);
		countByLottoRank.put(lottoRank, count(lottoRank) + COUNT_INCREMENT_UNIT);
	}
}
