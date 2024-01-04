package lotto.domain;

public enum Rank {
	RANK1(6, 2_000_000_000),
	RANK2(5, 1_500_000),
	RANK3(4, 50_000),
	RANK4(3, 5_000),
	MISS(0, 0);

	private final Integer matchingCount;
	private final Integer prize;

	Rank(final Integer matchingCount, final int prize) {
		this.matchingCount = matchingCount;
		this.prize = prize;
	}

	public static Rank findRank(final int matchingCount) {
		for (Rank rank : Rank.values()) {
			if (rank.matchingCount == matchingCount) {
				return rank;
			}
		}

		return Rank.MISS;
	}

	public static int calculate(final Rank rank, final int lottoCount) {
		return findPrize(rank) * lottoCount;
	}

	public static int findPrize(final Rank rank) {
		return rank.prize;
	}
}
