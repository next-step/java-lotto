package lottery;

import java.util.Arrays;

public enum LotteryMatchType {
	MISS_MATCH(0, Money.won(0L)),
	THREE_MATCH(3, Money.won(5_000L)),
	FOUR_MATCH(4, Money.won(50_000L)),
	FIVE_MATCH(5, Money.won(1_500_000L)),
	FIVE_MATCH_WITH_BONUS(5, Money.won(30_000_000L)),
	SIX_MATCH(6, Money.won(2_000_000_000L));

	private final int matchCount;
	private final Money money;

	LotteryMatchType(int matchCount, Money money) {
		this.matchCount = matchCount;
		this.money = money;
	}

	public Money money() {
		return money;
	}

	public int matchCount() {
		return matchCount;
	}

	public static LotteryMatchType byMatchCount(int matchCount) {
		return Arrays.stream(LotteryMatchType.values())
			.filter(matchType -> matchType.matchCount == matchCount)
			.findFirst()
			.orElse(MISS_MATCH);
	}
}
