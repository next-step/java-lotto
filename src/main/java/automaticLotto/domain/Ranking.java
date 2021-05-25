package automaticLotto.domain;

public enum Ranking {
	RANKING_LAST(0, 0), RANKING_4(3, 5000), RANKING_3(4, 500000), RANKING_2(5, 1500000), ANKING_1(6, 2000000000);

	private final int matchedCount;
	private final int winnerPrice;

	Ranking(int matchedCount, int winnerPrice) {
		this.matchedCount = matchedCount;
		this.winnerPrice = winnerPrice;
	}

	public int getMatchedCount() {
		return this.matchedCount;
	}

	public int getWinnerPrice() {
		return this.winnerPrice;
	}

	public static Ranking getWinnerPrice(int matchedCount) {
		for (Ranking ranking : values()) {
			if (ranking.getMatchedCount() == matchedCount) {
				return ranking;
			}
		}

		return RANKING_LAST;
	}
}
