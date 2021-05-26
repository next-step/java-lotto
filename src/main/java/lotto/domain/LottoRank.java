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

	private static final Map<LottoPoint, LottoRank> lottoPointIndex = new HashMap<>();

	static {
		lottoPointIndex.put(FIRST.lottoPoint, FIRST);
		lottoPointIndex.put(SECOND.lottoPoint, SECOND);
		lottoPointIndex.put(THIRD.lottoPoint, THIRD);
		lottoPointIndex.put(FOURTH.lottoPoint, FOURTH);
		lottoPointIndex.put(FIFTH.lottoPoint, FIFTH);
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

	static LottoRank rank(LottoPoint lottoPoint) {
		return lottoPointIndex.getOrDefault(lottoPoint, OUT_OF_RANK);
	}

}
