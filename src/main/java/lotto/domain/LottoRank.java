package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
	NOTHING(0, 0, false),
	FIFTH(3, 5000, false),
	FOURTH(4, 50000, false),
	THIRD(5, 1500000, false),
	SECOND(5, 30000000, true),
	FIRST(6, 2000000000, false);

	private final int matchCount;
	private final long earnings;
	private final boolean withBonus;

	LottoRank(int matchCount, long earnings, boolean withBonus) {
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

	public long getEarnings() {
		return earnings;
	}

	public static boolean isNotNoting(LottoRank rank) {
		return rank != NOTHING;
	}

	@Override
	public String toString() {
		if (withBonus) {
			return String.format("%d개 일치, 보너스 볼 일치 (%d원)", matchCount, earnings);
		}
		return String.format("%d개 일치, (%d원)", matchCount, earnings);
	}
}
