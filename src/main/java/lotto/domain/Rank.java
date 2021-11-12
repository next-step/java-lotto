package lotto.domain;

import java.util.Arrays;

import lotto.exception.RankMatchCountSizeException;

public enum Rank {
	MISS(0, 0),
	FIFTH(3, 5_000),
	FOURTH(4, 50_000),
	THIRD(5, 1_500_000),
	SECOND(5, 30_000_000),
	FIRST(6, 2_000_000_000);

	public static final int MIN_OF_MATCH = 0;
	public static final int MAX_OF_MATCH = 6;

	private final int countOfMatch;
	private final int winningMoney;

	Rank(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public static Rank from(int countOfMatch, boolean matchBonus) {
		validate(countOfMatch);

		if (isSecond(countOfMatch, matchBonus)) {
			return SECOND;
		}

		return Arrays.stream(values())
			.filter(rank -> matchesRank(rank, countOfMatch))
			.findFirst()
			.orElse(MISS);
	}

	private static boolean isSecond(int countOfMatch, boolean matchBonus) {
		return countOfMatch == SECOND.countOfMatch && matchBonus;
	}

	private static boolean matchesRank(Rank rank, int countOfMatch) {
		return rank != SECOND && rank.countOfMatch == countOfMatch;
	}

	private static void validate(int countOfMatch) {
		if (countOfMatch < MIN_OF_MATCH || countOfMatch > MAX_OF_MATCH) {
			throw new RankMatchCountSizeException();
		}
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}
}
