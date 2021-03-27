package lotto.domain;

public enum Ranking {
	THREE(3, 5_000),
	FOUR(4, 50_000),
	FIVE(5, 1_500_000),
	SIX(6, 2_000_000_000);

	private final int matchCount;
	private final int price;

	private Ranking(int matchCount, int price) {
		this.matchCount = matchCount;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public int getMatchCount() {
		return matchCount;
	}
}
