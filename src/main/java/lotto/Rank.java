package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Rank {

	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FOURTH(3, 5_000),
	LOSING(0, 0);

	private final long matchedCount;
	private final long prizeMoney;

	Rank(long matchedCount, long prizeMoney) {
		this.matchedCount = matchedCount;
		this.prizeMoney = prizeMoney;
	}

	public long getMatchedCount() {
		return matchedCount;
	}

	public long getPrizeMoney() {
		return prizeMoney;
	}

	public static Rank findByMatchedCount(long count) {
		return Arrays.stream(Rank.values())
				.filter(r -> count >= r.matchedCount)
				.max(Comparator.comparingLong(r -> r.matchedCount))
				.orElseThrow(() -> new IllegalArgumentException("등수를 매길 수 없습니다"));
	}

	public static List<Rank> getResultViewRanks() {
		return Arrays.asList(FIRST, SECOND, THIRD, FOURTH);
	}
}
