package lotto.constants;

import java.util.Arrays;

import static lotto.constants.MessageConstant.*;

public enum PrizeGrade {

	FIRST(6, false, 2_000_000_000, PRIZE_EXPLAIN_FORMAT, 5),
	SECOND(5, true, 30_000_000, SECOND_PRIZE_EXPLAIN_FORMAT, 4),
	THIRD(5, false, 1_500_000, PRIZE_EXPLAIN_FORMAT, 3),
	FOURTH(4, false, 50_000, PRIZE_EXPLAIN_FORMAT, 2),
	FIFTH(3, false, 5_000, PRIZE_EXPLAIN_FORMAT, 1),
	FAIL(-1, false, 0, PRIZE_EXPLAIN_FORMAT, 999999999);

	private static final int MATCH_TEST_REQUIRED_COUNT = 5;

	private final int matchCount;

	private final boolean shouldMatchBonus;

	private final long reward;

	private final String statisticsMessage;

	private final int printOrder;

	PrizeGrade(int matchCount, boolean shouldMatchBonus, long reward, String statisticsMessage, int printOrder) {
		this.matchCount = matchCount;
		this.shouldMatchBonus = shouldMatchBonus;
		this.reward = reward;
		this.statisticsMessage = statisticsMessage;
		this.printOrder = printOrder;
	}

	public static PrizeGrade of(int matchCount, boolean matchBonusNumber) {

		return Arrays.stream(PrizeGrade.values())
						.filter(prizeGrade -> prizeGrade.matchCount == matchCount)
						.filter(prizeGrade -> prizeGrade.matchCount != MATCH_TEST_REQUIRED_COUNT || (prizeGrade.shouldMatchBonus == matchBonusNumber))
						.findFirst()
						.orElseGet(() -> FAIL);
	}

	public long getReward() {
		return reward;
	}

	public String getStatisticsMessage() {
		return String.format(statisticsMessage, matchCount, reward);
	}

	public int getPrintOrder() {
		return printOrder;
	}
}
