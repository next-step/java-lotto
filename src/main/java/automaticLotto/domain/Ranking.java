package automaticLotto.domain;

public enum Ranking {
	RANKING_1(6, 2000000000), RANKING_2(5, 1500000), RANKING_3(4, 500000), RANKING_4(3, 5000);

	private final int matchedCount;
	private final int winnerPrice;

	Ranking(int matchedCount, int winnerPrice) {
		this.matchedCount = matchedCount;
		this.winnerPrice = winnerPrice;
	}

	public int getMatchedCount() {
		return this.matchedCount;
	}

	public int getwinnerPrice() {
		return this.winnerPrice;
	}
}
