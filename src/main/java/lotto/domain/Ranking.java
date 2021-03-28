package lotto.domain;

import java.util.Arrays;

public enum Ranking {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISS(0, 0);

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

	public static Ranking valueOf(int matchCount, boolean matchBonus) {

		if (matchCount == 5 && matchBonus) {
			return Ranking.SECOND;
		}
		if (matchCount == 5) {
			return Ranking.THIRD;
		}

		Ranking[] rankings = values();
		return Arrays.stream(rankings)
			.filter(ranking -> ranking.getMatchCount() == matchCount)
			.findFirst()
			.orElseGet(() -> Ranking.MISS);

	}
}
