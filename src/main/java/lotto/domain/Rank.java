package lotto.domain;

import java.util.HashMap;

public enum Rank {

	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FOURTH(3, 5_000),
	NONE(-1, 0);

	int matchCount;
	int winningMoney;

	Rank(int matchCount, int winningMoney) {
		this.matchCount = matchCount;
		this.winningMoney = winningMoney;
	}

	public static Rank findRankByMatchCount(int matchCount) {
		HashMap<Integer, Rank> rankMap = new HashMap<>();
		for (Rank rank : Rank.values()) {
			rankMap.put(rank.matchCount, rank);
		}
		if (rankMap.get(matchCount) != null) {
			return rankMap.get(matchCount);
		}
		return NONE;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getWinningMoney() {
		return winningMoney;
	}
}
