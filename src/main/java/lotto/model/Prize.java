package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Prize {
	FIRST(6, 2_000_000_000, false),
	SECOND(5, 30_000_000, true),
	THIRD(5, 1_500_000, false),
	FOURTH(4, 50_000, false),
	FIFTH(3, 5_000, false),
	MISS(0, 0, false);

	private final int countOfMatch;
	private final int winningMoney;
	private final boolean matchBonus;

	Prize(int countOfMatch, int winningMoney, boolean matchBonus) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
		this.matchBonus = matchBonus;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public boolean getMatchBonus() {
		return matchBonus;
	}

	public static List<Prize> getValuesMoneySort() {
		return Arrays.stream(Prize.values())
			.sorted(Comparator.comparing(Prize::getWinningMoney))
			.collect(Collectors.toList());
	}

	public static Prize getWinnersStatus(int countOfMatch, boolean matchBonus) {
		return Arrays.stream(Prize.values())
			.filter(r -> r.countOfMatch == countOfMatch && (matchBonus & r.matchBonus) == r.matchBonus)
			.findFirst()
			.orElse(MISS);
	}
}
