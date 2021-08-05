package lotto.enums;

import java.util.Arrays;

public enum Rank {
	NOTHING(0L, 0),
	FOURTH(3L, 5000),
	THIRD(4L, 50000),
	SECOND(5L, 1500000),
	FIRST(6L, 2000000000);

	private final long matchNumberCount;
	private final int reward;

	Rank(long matchNumberCount, int reward) {
		this.matchNumberCount = matchNumberCount;
		this.reward = reward;
	}

	public static Rank of(long matchNumberCount) {
		return Arrays.stream(Rank.values())
					.filter(e -> e.matchNumberCount == matchNumberCount)
					.findFirst()
					.orElse(NOTHING);
	}

	public int getReward() {
		return reward;
	}
}
