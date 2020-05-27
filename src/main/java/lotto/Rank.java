package lotto;

import java.util.Arrays;
import java.util.Comparator;

public enum Rank {

	First(6, 2_000_000_000),
	Second(5, 1_500_000),
	Third(4, 50_000),
	Fourth(3, 5_000),
	Losing(0, 0);

	private final long matchedCount;
	private final long prizeMoney;

	Rank(long matchedCount, long prizeMoney) {
		this.matchedCount = matchedCount;
		this.prizeMoney = prizeMoney;
	}

	public static Rank findByMatchedCount(long count) {
		return Arrays.stream(Rank.values())
				.filter(r -> count >= r.matchedCount)
				.max(Comparator.comparingLong(r -> r.matchedCount))
				.orElseThrow(() -> new IllegalArgumentException("등수를 매길 수 없습니다"));
	}
}
