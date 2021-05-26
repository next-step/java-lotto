package lotto.domain;

import java.util.Arrays;

public enum Rank {

	FIRST(6, 2_000_000_000, false),
	SECOND(5, 30_000_000, true),
	THIRD(5, 1_500_000, false),
	FOURTH(4, 50_000, false),
	FIFTH(3, 5_000, false),
	NONE(-1, 0, false);

	private int matchCount;
	private int winningMoney;
	private boolean matchBonusNumber;

	Rank(int matchCount, int winningMoney, boolean matchBonusNumber) {
		this.matchCount = matchCount;
		this.winningMoney = winningMoney;
		this.matchBonusNumber = matchBonusNumber;
	}

	public static Rank findRank(int matchCount, boolean matchBonusNumber) {
		return Arrays.stream(Rank.values())
				.filter(rank -> rank.isMatch(matchCount, matchBonusNumber))
				.findFirst()
				.orElse(NONE);
	}

	public boolean isMatch(int matchCount, boolean matchBonusNumber) {
		if (matchBonusNumber) {
			return this.matchCount == matchCount;
		}
		return this.matchCount == matchCount && !this.matchBonusNumber;
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
		if (this.matchCount == rank.getMatchCount()) {
			return this.winningMoney > rank.getWinningMoney();
		}
		return this.matchCount > rank.getMatchCount();
	}
}
