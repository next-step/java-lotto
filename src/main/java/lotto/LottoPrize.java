package lotto;

import java.util.Arrays;

public enum LottoPrize {

	MATCH_ZERO(0, 0),
	MATCH_THREE(3, 5_000),
	MATCH_FOUR(4, 50_000),
	MATCH_FIVE(5, 1_500_000),
	MATCH_SIX(6, 2_000_000_000);

	private long matchCount;
	private int winningAmount;

	public static LottoPrize getLottoPrizeFromMatchCount(long matchedNumberCount) {
		return Arrays.stream(LottoPrize.values())
			.filter(it -> it.matchCount == matchedNumberCount)
			.findFirst()
			.orElse(MATCH_ZERO);
	}

	LottoPrize(int matchCount, int winningAmount) {
		this.matchCount = matchCount;
		this.winningAmount = winningAmount;
	}

	public int getWinningAmount() {
		return winningAmount;
	}
	public long getMatchCount() {
		return matchCount;
	}
}
