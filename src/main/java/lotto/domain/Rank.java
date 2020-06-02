package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {

	FIRST(6, 0, 2_000_000_000),
	SECOND(5, 1, 30_000_000),
	THIRD(5, 0, 1_500_000),
	FOURTH(4, 0, 50_000),
	FIFTH(3, 0, 5_000),
	LOSING(0, 0, 0);

	private final long matchedCount;
	private final long matchedBonusCount;
	private final long prizeMoney;

	Rank(long matchedCount, long matchedBonusCount, long prizeMoney) {
		this.matchedCount = matchedCount;
		this.matchedBonusCount = matchedBonusCount;
		this.prizeMoney = prizeMoney;
	}

	public long getMatchedCount() {
		return matchedCount;
	}

	public long getMatchedBonusCount() {
		return matchedBonusCount;
	}

	public long getPrizeMoney() {
		return prizeMoney;
	}

	public static Rank findByMatchedCount(long matchedCount, long matchedBonusCount) {
		return Arrays.stream(Rank.values())
				.filter(r -> matchedCount >= r.matchedCount)
				.filter(r -> matchedBonusCount >= r.matchedBonusCount)
				.findFirst()
				.orElse(Rank.LOSING);
	}

	public static List<Rank> getResultViewRanks() {
		return Arrays.asList(FIRST, SECOND, THIRD, FOURTH);
	}
}
