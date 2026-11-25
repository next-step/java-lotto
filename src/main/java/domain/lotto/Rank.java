package domain.lotto;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FOURTH(3, 5_000),
	MISS(0, 0);

	private final int matchCount;
	private final int prize;
	private static final Map<Integer, Rank> RANKS = new HashMap<>();

	static {
		for (Rank rank : values()) {
			RANKS.put(rank.matchCount, rank);
		}
	}

	Rank(int matchCount, int prize) {
		this.matchCount = matchCount;
		this.prize = prize;
	}

	public int getPrize() {
		return prize;
	}

	public static Rank from(int matchCount) {
		return RANKS.getOrDefault(matchCount, MISS);
	}
}
