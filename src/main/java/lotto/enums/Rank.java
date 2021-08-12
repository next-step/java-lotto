package lotto.enums;

import java.util.Arrays;

public enum Rank {
	NOTHING(0L, false, 0L),
	FIFTH(3L, false, 5_000L),
	FOURTH(4L, false, 50_000L),
	THIRD(5L, false, 1_500_000L),
	SECOND(5L, true, 30_000_000),
	FIRST(6L, false, 2_000_000_000L);

	private final long matchNumberCount;
	private final boolean matchBonusNumber;
	private final long reward;

	Rank(long matchNumberCount, boolean matchBonusNumber, long reward) {
		this.matchNumberCount = matchNumberCount;
		this.matchBonusNumber = matchBonusNumber;
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
