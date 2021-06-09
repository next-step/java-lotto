package com.nextstep.lotto.result;

import java.util.Arrays;

public enum LottoRank {
	NO_RANK(0, 0),
	FIFTH_RANK(3, 5000),
	FOURTH_RANK(4, 50000),
	THIRD_RANK(5, 1500000),
	SECOND_RANK(5, 30000000),
	FIRST_RANK(6, 2000000000);

	private final int matchCount;
	private final int reward;

	LottoRank(int matchCount, int reward) {
		this.matchCount = matchCount;
		this.reward = reward;
	}

	public static LottoRank valueOf(int matchCount, boolean isMatchBonus) {
		if (matchCount == SECOND_RANK.getMatchCount()) {
			return rankByMatchBonus(isMatchBonus);
		}

		return Arrays.stream(LottoRank.values())
			.filter(rank -> rank.matchCount == matchCount)
			.findAny()
			.orElse(NO_RANK);
	}

	private static LottoRank rankByMatchBonus(boolean isMatchBonus) {
		if (isMatchBonus) {
			return SECOND_RANK;
		}
		return THIRD_RANK;
	}

	public int getReward() {
		return this.reward;
	}

	public int getMatchCount() {
		return this.matchCount;
	}
}
