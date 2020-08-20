package lotto.domain;

import java.util.Arrays;

public enum PrizeGrade {

	FIRST(6, false, 2_000_000_000),
	SECOND(5, true, 30_000_000),
	THIRD(5, false, 1_500_000),
	FOURTH(4, false, 50_000),
	FIFTH(3, false, 5_000),
	FAIL(-1, false, 0);

	private static final int MATCH_TEST_REQUIRED_COUNT = 5;

	private final int matchCount;

	private final boolean shouldMatchBonus;

	private final long reward;

	PrizeGrade(int matchCount, boolean shouldMatchBonus, long reward) {
		this.matchCount = matchCount;
		this.shouldMatchBonus = shouldMatchBonus;
		this.reward = reward;
	}

	public static PrizeGrade of(int matchCount, boolean matchBonusNumber) {

		return Arrays.stream(PrizeGrade.values())
						.filter(prizeGrade -> prizeGrade.matchCount == matchCount)
						.filter(prizeGrade -> prizeGrade.matchCount != MATCH_TEST_REQUIRED_COUNT || (prizeGrade.shouldMatchBonus == matchBonusNumber))
						.findFirst()
						.orElseGet(() -> FAIL);
	}

	public int getMatchCount() {
		return matchCount;
	}

	public long getReward() {
		return reward;
	}
}
