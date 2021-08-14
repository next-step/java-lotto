package lotto.enums;

import java.util.Arrays;

public enum Rank {
	NOTHING(0L, 0L),
	FIFTH(3L, 5_000L),
	FOURTH(4L, 50_000L),
	THIRD(5L, 1_500_000L),
	SECOND(5L, 30_000_000),
	FIRST(6L, 2_000_000_000L);

	private final long matchNumberCount;
	private final long reward;

	Rank(long matchNumberCount, long reward) {
		this.matchNumberCount = matchNumberCount;
		this.reward = reward;
	}

	public static Rank of(long matchNumberCount, boolean matchBonusNumber) {
		Rank rank = Arrays.stream(Rank.values())
						.filter(e -> e.matchNumberCount == matchNumberCount)
						.findFirst()
						.orElse(NOTHING);

		if (matchNumberCount == 5L && matchBonusNumber) {
			rank = Rank.SECOND;
		}

		return rank;
	}

	public long getReward() {
		return reward;
	}

	public long getMatchNumberCount() {
		return matchNumberCount;
	}
}
