package step3.domain;

import java.util.Arrays;

public enum LottoWinning {
	THREE(3, false, 5_000),
	FOUR(4, false, 50_000),
	FIVE(5, false, 1_500_000),
	BONUS(5, true, 30_000_000),
	SIX(6, false, 2_000_000_000),
	NOTHING(0, false, 0)
	;

	private final int matchingCount;
	private final boolean isBonus;
	private final int reward;

	LottoWinning(int matchingCount, boolean isBonus, int reward) {
		this.matchingCount = matchingCount;
		this.isBonus = isBonus;
		this.reward = reward;
	}

	public int getMatchingCount() {
		return matchingCount;
	}

	public boolean isBonus() {
		return isBonus;
	}

	public int getReward() {
		return reward;
	}

	public static LottoWinning valueOf(int matchingCount, boolean bonus) {
		if (isEqualMatchCount(matchingCount, FIVE.matchingCount) && bonus) {
			return LottoWinning.BONUS;
		}
		return Arrays.stream(values())
				.filter(winning -> isEqualMatchCount(matchingCount, winning.matchingCount))
				.findFirst()
				.orElse(NOTHING);
	}

	private static boolean isEqualMatchCount(int matchingCount, int winningCount) {
		return matchingCount == winningCount;
	}

}
