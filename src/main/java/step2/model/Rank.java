package step2.model;

public enum Rank {
	FIRST(6, 2000000000),
	SECOND(5, 1500000),
	THIRD(4, 50000),
	FOURTH(3, 5000),
	LOSE(0, 0);

	private static final int MIN_MATCH_COUNT = 3;

	private int matchCount;
	private int prize;

	Rank(int matchCount, int prize) {
		this.matchCount = matchCount;
		this.prize = prize;
	}

	public int getMatchCount() {
		return this.matchCount;
	}

	public int getPrize() {
		return this.prize;
	}

	public static Rank valueOf(int matchCount) {
		if (matchCount < MIN_MATCH_COUNT) {
			return LOSE;
		}
		for (Rank rank : values()) {
			if (rank.matchCount == matchCount) return rank;
		}
		throw new IllegalArgumentException();
	}
}
