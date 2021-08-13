package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Prize {
	FIRST(6, 2_000_000_000, MatchBonusType.NONE),
	SECOND(5, 30_000_000, MatchBonusType.TRUE),
	THIRD(5, 1_500_000, MatchBonusType.FALSE),
	FOURTH(4, 50_000, MatchBonusType.NONE),
	FIFTH(3, 5_000, MatchBonusType.NONE),
	MISS(0, 0, MatchBonusType.NONE);

	private final int countOfMatch;
	private final int winningMoney;
	private final MatchBonusType matchBonusType;

	Prize(int countOfMatch, int winningMoney, MatchBonusType matchBonusType) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
		this.matchBonusType = matchBonusType;
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
			.filter(prize -> (prize.countOfMatch == countOfMatch) && prize.matchBonusType.isBonusMatch(matchBonus))
			.findFirst()
			.orElse(MISS);
	}
}
