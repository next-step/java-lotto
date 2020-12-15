package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
	NOTHING(0, 0, false),
	FIFTH(3, 5000, false),
	FOURTH(4, 50000, false),
	THIRD(5, 1500000, false),
	SECOND(5, 30000000, true),
	FIRST(6, 2000000000, false);

	private final int matchCount;
	private final long earnings;
	private final boolean needBonus;

	LottoRank(int matchCount, long earnings, boolean needBonus) {
		this.matchCount = matchCount;
		this.earnings = earnings;
		this.needBonus = needBonus;
	}

	public static LottoRank valueOfMatchCountAndMatchBonus(int matchCount, boolean isMatchBonus) {
		List<LottoRank> matchedRanks = valuesOfMatchCount(matchCount);
		return matchedRanks.stream()
			.filter(rank -> isMatchBonus && rank.isNeedBonus())
			.findFirst()
			.orElse(LottoRank.valueOfWithoutBonus(matchedRanks));
	}

	private static LottoRank valueOfWithoutBonus(List<LottoRank> matchedRanks) {
		return matchedRanks.stream()
			.filter(rank -> !rank.isNeedBonus())
			.findFirst()
			.orElse(LottoRank.NOTHING);
	}

	private static List<LottoRank> valuesOfMatchCount(int matchCount) {
		return Arrays.stream(LottoRank.values())
			.filter(rank -> rank.isMatchCount(matchCount))
			.collect(Collectors.toList());
	}

	private boolean isMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}

	private boolean isNeedBonus() {
		return this.needBonus;
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
		if (isNeedBonus()) {
			return String.format("%d개 일치, 보너스 볼 일치 (%d원)", matchCount, earnings);
		}
		return String.format("%d개 일치, (%d원)", matchCount, earnings);
	}
}
