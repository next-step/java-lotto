package lotto;

import java.util.Arrays;

public enum LottoRank {
	NOTHING(0, 0),
	FOURTH(3, 5000),
	THIRD(4, 50000),
	SECOND(5, 1500000),
	FIRST(6, 2000000000);

	private final int matchCount;
	private final int earnings;

	LottoRank(int matchCount, int earnings) {
		this.matchCount = matchCount;
		this.earnings = earnings;
	}

	public static LottoRank valueOfMatchCount(int matchCount) {
		return Arrays.stream(LottoRank.values())
			.filter(rank -> rank.matchCount == matchCount)
			.findFirst()
			.orElse(LottoRank.NOTHING);
	}

	public long calculateEarnings(int count) {
		return this.earnings * count;
	}

	public int getEarnings() {
		return earnings;
	}
}
