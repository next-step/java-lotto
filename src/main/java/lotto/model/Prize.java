package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Prize {
	FIRST(6, 2_000_000_000, BonusMatchType.NONE),
	SECOND(5, 30_000_000, BonusMatchType.TRUE),
	THIRD(5, 1_500_000, BonusMatchType.FALSE),
	FOURTH(4, 50_000, BonusMatchType.NONE),
	FIFTH(3, 5_000, BonusMatchType.NONE),
	MISS(0, 0, BonusMatchType.NONE);

	private final int countOfMatch;
	private final int winningMoney;
	private final BonusMatchType bonusMatchType;

	Prize(int countOfMatch, int winningMoney, BonusMatchType bonusMatchType) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
		this.bonusMatchType = bonusMatchType;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public static List<Prize> getValuesMoneySort() {
		return Arrays.stream(Prize.values())
			.sorted(Comparator.comparing(Prize::getWinningMoney))
			.collect(Collectors.toList());
	}

	public static Prize getWinnersStatus(int countOfMatch, boolean matchBonus) {
		return Arrays.stream(Prize.values())
			.filter(prize -> (prize.countOfMatch == countOfMatch) && prize.bonusMatchType.isBonusMatch(matchBonus))
			.findFirst()
			.orElse(MISS);
	}
}
