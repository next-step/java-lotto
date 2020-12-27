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
	private final boolean hasBonus;

	LottoRank(int countOfMatch, int winningMoney, boolean hasBonus) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
		this.hasBonus = hasBonus;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public boolean isHasBonus() {
		return hasBonus;
	}

	public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
		return Arrays.stream(LottoRank.values())
			.filter(lr -> lr.countOfMatch == countOfMatch && (!lr.hasBonus || matchBonus))
			.findFirst()
			.orElse(LottoRank.MISS);
	}
}
