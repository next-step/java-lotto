package step2.model;

import java.util.Arrays;

public enum Rank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISS(0, 0);

	private int countOfMatch;
	private long winningMoney;

	Rank(int countOfMatch, long winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public long getWinningMoney() {
		return winningMoney;
	}

	public static Rank of(int countOfMatch, boolean isBonus) {
		return Arrays.stream(Rank.values())
			.filter(rank ->
				isMatchCount(countOfMatch, rank))
			.filter(rank -> !rank.equals(SECOND) || isBonus)
			.findFirst()
			.orElse(MISS);
	}

	private static boolean isMatchCount(int countOfMatch, Rank rank) {
		return rank.getCountOfMatch() == countOfMatch;
	}

}
