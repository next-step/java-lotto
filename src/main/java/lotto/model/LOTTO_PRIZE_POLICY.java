package lotto.model;

public enum LOTTO_PRIZE_POLICY {
	THREE_MATCH_PRIZE(3, 5000),
	FOUR_MATCH_PRIZE(4, 50000),
	FIVE_MATCH_PRIZE(5, 1500000),
	SIX_MATCH_PRIZE(6, 2000000000);

	private int matchCount;
	
	private int prizeMoney;

	LOTTO_PRIZE_POLICY(int matchCount, int prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

	public static int getPrizeMoney(int matchCount) {
		for (LOTTO_PRIZE_POLICY policy : LOTTO_PRIZE_POLICY.values()) {
			if (policy.getMatchCount() == matchCount) {
				return policy.getPrizeMoney();
			}
		}
		return 0;
	}
}



