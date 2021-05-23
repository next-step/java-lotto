package lottery;

public enum LotteryMatchType {
	MISS_MATCH(-1, Money.won(0L)),
	THREE_MATCH(3, Money.won(5000L)),
	FOUR_MATCH(4, Money.won(50000L)),
	FIVE_MATCH(5, Money.won(1500000L)),
	SIX_MATCH(6, Money.won(2000000000L));

	private final int matchCount;
	private final Money money;

	LotteryMatchType(int matchCount, Money money) {
		this.matchCount = matchCount;
		this.money = money;
	}

	public Money money() {
		return money;
	}

	public static LotteryMatchType fromInteger(int matchNumber) {
		for (LotteryMatchType lotteryMatchType : LotteryMatchType.values()){
			return getLotteryMatchType(matchNumber, lotteryMatchType);
		}
		return MISS_MATCH;
	}

	private static LotteryMatchType getLotteryMatchType(int matchNumber, LotteryMatchType lotteryMatchType) {
		if (lotteryMatchType.matchCount == matchNumber){
			return lotteryMatchType;
		}
		return MISS_MATCH;
	}
}
