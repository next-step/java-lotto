package lotto.domain;

public enum Ranking {
	THREE(3, 5000),
	FOUR(4, 50000),
	FIVE(5, 1500000),
	SIX(6, 2000000000);

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
