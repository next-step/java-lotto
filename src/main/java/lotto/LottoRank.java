package lotto;

import java.util.Arrays;

public enum LottoRank {
	NOTHING(0),
	FOURTH(3),
	THIRD(4),
	SECOND(5),
	FIRST(6);

	private final int matchCount;

	LottoRank(int matchCount) {
		this.matchCount = matchCount;
	}

	public static LottoRank valueOfMatchCount(int matchCount) {
		return Arrays.stream(LottoRank.values())
			.filter(rank -> rank.matchCount == matchCount)
			.findFirst()
			.orElse(LottoRank.NOTHING);
	}
}
