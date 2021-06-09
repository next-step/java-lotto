package com.nextstep.lotto.result;

import java.util.Arrays;

public enum LottoRank {
	FIRST_RANK(6, 2000000000),
	SECOND_RANK(5, 30000000),
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

	public static LottoRank valueOf(int matchCount, boolean matchBonus) {
		if (matchCount == SECOND_RANK.getMatchCount()) {
			return getLottoRank(matchBonus);
		}

		return Arrays.stream(LottoRank.values())
			.filter(c -> c.matchCount == matchCount)
			.findAny()
			.orElse(NO_RANK);
	}

	private static LottoRank getLottoRank(boolean matchBonus) {
		if (matchBonus) {
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
