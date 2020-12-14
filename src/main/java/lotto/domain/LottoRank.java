package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
	FIRST(6, 2000000000, false),
	SECOND(5, 30000000, true),
	THIRD(5, 1500000, false),
	FOURTH(4, 50000, false),
	FIFTH(3, 5000, false),
	NOTHING(0, 0, false);

	private final int matchCount;
	private final int earnings;
	private final boolean withBonus;

	LottoRank(int matchCount, int earnings, boolean withBonus) {
		this.matchCount = matchCount;
		this.earnings = earnings;
		this.withBonus = withBonus;
	}

	public static LottoRank valueOfMatchCountAndMatchBonus(int matchCount, boolean isMatchBonus) {
		return Arrays.stream(LottoRank.values())
			.filter(rank -> rank.matchCount == matchCount && rank.withBonus && isMatchBonus)
			.findFirst()
			.orElse(LottoRank.valueOfMatchCountWithoutBonus(matchCount));
	}

	public static LottoRank valueOfMatchCountWithoutBonus(int matchCount) {
		return Arrays.stream(LottoRank.values())
			.filter(rank -> rank.matchCount == matchCount && !rank.withBonus)
			.findFirst()
			.orElse(LottoRank.NOTHING);
	}

	public long calculateEarnings(int count) {
		return this.earnings * count;
	}

	public int getEarnings() {
		return earnings;
	}

	public static boolean isNotNoting(LottoRank rank) {
		return rank != NOTHING;
	}

	@Override
	public String toString() {
		return matchCount + "개 일치 (" + earnings + "원)";
	}
}
