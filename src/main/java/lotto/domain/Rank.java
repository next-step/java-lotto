package lotto.domain;

import java.util.Arrays;

public enum Rank {

	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FOURTH(3, 5_000),
	NONE(-1, 0);

	private int matchCount;
	private int winningMoney;

	Rank(int matchCount, int winningMoney) {
		this.matchCount = matchCount;
		this.winningMoney = winningMoney;
	}

	public static Rank findRankByMatchCount(int matchCount) {
		return Arrays.stream(Rank.values())
				.filter(rank -> rank.matchCount == matchCount)
				.findFirst()
				.orElse(NONE);
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public long multiplyWinningMoney(int rankCount) {
		return this.winningMoney * rankCount;
	}

	public boolean isGreaterThan(Rank rank) {
		return this.matchCount > rank.getMatchCount();
	}
}
