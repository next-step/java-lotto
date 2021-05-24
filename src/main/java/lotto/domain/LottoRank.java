package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoRank {

	FIRST(6, 2_000_000_000L),
	SECOND(5, 1_500_000L),
	THIRD(4, 50000L),
	FOURTH(3, 5000L),
	OUT_OF_RANK(0, 0L);

	private static final Map<Integer, LottoRank> LOTTO_RANK_MAP = new HashMap<>();

	static {
		LOTTO_RANK_MAP.put(FIRST.matchCount, FIRST);
		LOTTO_RANK_MAP.put(SECOND.matchCount, SECOND);
		LOTTO_RANK_MAP.put(THIRD.matchCount, THIRD);
		LOTTO_RANK_MAP.put(FOURTH.matchCount, FOURTH);
	}

	private final int matchCount;
	private final long money;

	public int matchCount() {
		return matchCount;
	}

	public long money() {
		return money;
	}

	LottoRank(int matchCount, long money) {
		this.matchCount = matchCount;
		this.money = money;
	}

	static LottoRank rank(int matchCount) {
		return getLottoRank(matchCount);
	}

	private static LottoRank getLottoRank(int matchCount) {
		return LOTTO_RANK_MAP.getOrDefault(matchCount, OUT_OF_RANK);
	}

}
