package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Prize {
	FIRST(6, 2_000_000_000, MatchType.NONE),
	SECOND(5, 30_000_000, MatchType.TRUE),
	THIRD(5, 1_500_000, MatchType.FALSE),
	FOURTH(4, 50_000, MatchType.NONE),
	FIFTH(3, 5_000, MatchType.NONE),
	MISS(0, 0, MatchType.NONE);

	private final int countOfMatch;
	private final int winningMoney;
	private final MatchType matchType;

	Prize(int countOfMatch, int winningMoney, MatchType matchType) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
		this.matchType = matchType;
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
			.filter(prize -> (prize.countOfMatch == countOfMatch) && prize.matchType.isBonusMatch(matchBonus))
			.findFirst()
			.orElse(MISS);
	}
}
