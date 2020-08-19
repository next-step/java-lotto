package step3.constants;

import java.util.Arrays;

public enum PrizeGrade {

	FIRST(6, false, 2_000_000_000, 5),
	SECOND(5, true, 30_000_000, 4),
	THIRD(5, false, 1_500_000, 3),
	FOURTH(4, false, 50_000, 2),
	FIFTH(3, false, 5_000, 1),
	FAIL(-1, false, 0, 999999999);

	private static final int MATCH_TEST_REQUIRED_COUNT = 5;

	private final int matchCount;

	private final boolean shouldMatchBonus;

	private final long reward;

	private final int printOrder;

	PrizeGrade(int matchCount, boolean shouldMatchBonus, long reward, int printOrder) {
		this.matchCount = matchCount;
		this.shouldMatchBonus = shouldMatchBonus;
		this.reward = reward;
		this.printOrder = printOrder;
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

	public int getPrintOrder() {
		return printOrder;
	}
}
