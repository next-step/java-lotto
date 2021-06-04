package com.nextstep.lotto.result;

import java.util.Arrays;

public enum LottoRank {
	FIRST_RANK(6, 2000000000),
	THIRD_RANK(5, 1500000),
	FOURTH_RANK(4, 50000),
	FIFTH_RANK(3, 5000),
	NO_RANK(0, 0);

	private final int matchCount;
	private final int reward;

	LottoRank(int matchCount, int reward) {
		this.matchCount = matchCount;
		this.reward = reward;
	}

	public static LottoRank match(int matchCount) {
		if (matchCount < FIFTH_RANK.matchCount) {
			return NO_RANK;
		}

		if (FIRST_RANK.matchCount == matchCount) {
			return FIRST_RANK;
		}

		if (THIRD_RANK.matchCount == matchCount) {
			return THIRD_RANK;
		}

		if (FOURTH_RANK.matchCount == matchCount) {
			return FOURTH_RANK;
		}

		if (FIFTH_RANK.matchCount == matchCount) {
			return FIFTH_RANK;
		}

		return null;
	}

	public static LottoRank valueOf(int matchCount) {
		return Arrays.stream(LottoRank.values())
			.filter(c -> c.matchCount == matchCount)
			.findAny()
			.orElse(NO_RANK);
	}

	public int getReward() {
		return this.reward;
	}

	public int getMatchCount() {
		return this.matchCount;
	}
}
