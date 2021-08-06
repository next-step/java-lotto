package lotto.enums;

import java.util.Arrays;

public enum Rank {
	NOTHING(0L, 0L),
	FOURTH(3L, 5000L),
	THIRD(4L, 50000L),
	SECOND(5L, 1500000L),
	FIRST(6L, 2000000000L);

	private final long matchNumberCount;
	private final long reward;

	Rank(long matchNumberCount, long reward) {
		this.matchNumberCount = matchNumberCount;
		this.reward = reward;
	}

	public static Rank of(long matchNumberCount) {
		return Arrays.stream(Rank.values())
					.filter(e -> e.matchNumberCount == matchNumberCount)
					.findFirst()
					.orElse(NOTHING);
	}

	public long getReward() {
		return reward;
	}

	public long getMatchNumberCount() {
		return matchNumberCount;
	}
}
