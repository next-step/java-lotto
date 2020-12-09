package com.woowahan.lotto.model;

import java.util.Arrays;

import com.woowahan.lotto.constant.Message;

public enum LottoResultType {
	ZERO_MATCH(0, 0),
	ONE_MATCH(1, 0),
	TWO_MATCH(2, 0),
	THREE_MATCH(3, 5000L),
	FOUR_MATCH(4, 50000L),
	FIVE_MATCH(5, 1500000L),
	SIX_MATCH(6, 2000000000L);

	private final int matchCount;
	private final long reward;

	LottoResultType(int matchCount, long reward) {
		this.matchCount = matchCount;
		this.reward = reward;
	}

	public static LottoResultType getResultTypeByMatchCount(int matchCount) {
		return Arrays.stream(LottoResultType.values())
			.filter(resultType -> matchCount == resultType.getMatchCount())
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Message.MSG_NOT_FOUND_RESULT_TYPE));
	}

	public int getMatchCount() {
		return matchCount;
	}

}
