package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoRank {

	FIRST(6, new LottoPoint(6), 2_000_000_000L),
	SECOND(5, new LottoPoint(5, true), 30_000_000),
	THIRD(5, new LottoPoint(5), 1_500_000L),
	FOURTH(4, new LottoPoint(4), 50_000L),
	FIFTH(3, new LottoPoint(3), 5000L),
	OUT_OF_RANK(0, new LottoPoint(0), 0L);

	private static final Map<Integer, LottoRank> LOTTO_RANK_MAP = new HashMap<>();
	private static final Map<LottoPoint, LottoRank> NEW_LOTTO_RANK_MAP = new HashMap<>();

	static {
		LOTTO_RANK_MAP.put(FIRST.matchCount, FIRST);
		LOTTO_RANK_MAP.put(SECOND.matchCount, SECOND);
		LOTTO_RANK_MAP.put(THIRD.matchCount, THIRD);
		LOTTO_RANK_MAP.put(FOURTH.matchCount, FOURTH);
		LOTTO_RANK_MAP.put(FIFTH.matchCount, FIFTH);
		NEW_LOTTO_RANK_MAP.put(FIRST.lottoPoint, FIRST);
		NEW_LOTTO_RANK_MAP.put(SECOND.lottoPoint, SECOND);
		NEW_LOTTO_RANK_MAP.put(THIRD.lottoPoint, THIRD);
		NEW_LOTTO_RANK_MAP.put(FOURTH.lottoPoint, FOURTH);
		NEW_LOTTO_RANK_MAP.put(FIFTH.lottoPoint, FIFTH);
	}

	private final int matchCount;
	private final LottoPoint lottoPoint;
	private final long money;

	public int matchCount() {
		return matchCount;
	}

	public long money() {
		return money;
	}

	LottoRank(int matchCount, LottoPoint lottoPoint, long money) {
		this.matchCount = matchCount;
		this.lottoPoint = lottoPoint;
		this.money = money;
	}

	static LottoRank rank(int matchCount) {
		return getLottoRank(matchCount);
	}

	static LottoRank rank(LottoPoint lottoPoint) {
		return NEW_LOTTO_RANK_MAP.getOrDefault(lottoPoint, OUT_OF_RANK);
	}

	private static LottoRank getLottoRank(int matchCount) {
		return LOTTO_RANK_MAP.getOrDefault(matchCount, OUT_OF_RANK);
	}

}
