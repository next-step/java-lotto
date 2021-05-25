package lotto.domain;

public enum Rank {

	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	NONE(-1, 0);

	private int matchCount;
	private int winningMoney;

	Rank(int matchCount, int winningMoney) {
		this.matchCount = matchCount;
		this.winningMoney = winningMoney;
	}

	public static Rank findRank(int matchCount, boolean matchBonusNumber) {
		if (SECOND.isMatch(matchCount) && matchBonusNumber) {
			return SECOND;
		}
		for (Rank rank : values()) {
			if (rank.isMatch(matchCount) && rank != SECOND) {
				return rank;
			}
		}
		return NONE;
	}

	public boolean isMatch(int matchCount) {
		return this.matchCount == matchCount;
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
