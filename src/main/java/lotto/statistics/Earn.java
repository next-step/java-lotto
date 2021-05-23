package lotto.statistics;

public enum Earn {
	THREE_MATCHED(3, 5_000),
	FOUR_MATCHED(4,50_000),
	FIVE_MATCHED(5, 1_500_000),
	SIX_MATCHED(6,  2_000_000_000);

	Earn(int matchCount, int earn) {
		this.matchCount = matchCount;
		this.earn = earn;
	}

	private int matchCount;
	private int earn;

	public static Earn match(int matchCount) {
		if (matchCount == 3) {
			return THREE_MATCHED;
		}
		if (matchCount == 4) {
			return FOUR_MATCHED;
		}
		if (matchCount == 5) {
			return FIVE_MATCHED;
		}
		if (matchCount == 6) {
			return SIX_MATCHED;
		}
		throw new IllegalArgumentException("match count 는 3, 4, 5, 6 만 사용이 가능합니다");
	}

	public int winningPrice() {
		return earn;
	}
}
