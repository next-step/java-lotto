package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
	FIRST(6, 2_000_000_000, false),
	SECOND(5, 30_000_000, true),
	THIRD(5, 1_500_000, false),
	FOURTH(4, 50_000, false),
	FIFTH(3, 5_000, false),
	MISS(0, 0, false);

	private final int countOfMatch;
	private final int winningMoney;
	private final boolean isIncludeBonus;

	LottoRank(int countOfMatch, int winningMoney, boolean isIncludeBonus) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
		this.isIncludeBonus = isIncludeBonus;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public boolean isIncludeBonus() {
		return isIncludeBonus;
	}

	public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
		return Arrays.stream(LottoRank.values())
			.filter(lr -> lr.countOfMatch == countOfMatch && (!lr.isIncludeBonus || matchBonus))
			.findFirst().orElse(LottoRank.MISS);
	}
}
