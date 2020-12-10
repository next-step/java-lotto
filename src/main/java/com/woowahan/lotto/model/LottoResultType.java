package com.woowahan.lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.woowahan.lotto.constant.Message;

public enum LottoResultType {
	ZERO_MATCH(0, false, 0),
	ONE_MATCH(1, false, 0),
	TWO_MATCH(2, false, 0),
	THREE_MATCH(3, false, 5000L),
	FOUR_MATCH(4, false, 50000L),
	FIVE_MATCH(5, false, 1500000L),
	FIVE_MATCH_AND_BONUS(5, true, 30000000L),
	SIX_MATCH(6, false, 2000000000L);

	private final int matchCount;
	private final boolean isBonusMatch;
	private final long reward;

	LottoResultType(int matchCount, boolean isBonusMatch, long reward) {
		this.matchCount = matchCount;
		this.isBonusMatch = isBonusMatch;
		this.reward = reward;
	}

	public static LottoResultType findResultType(int matchCount, boolean isBonusMatch) {
		return Arrays.stream(LottoResultType.values())
			.filter(resultType -> matchCount == resultType.getMatchCount()
				&& isBonusMatch == resultType.isBonusMatch())
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Message.MSG_NOT_FOUND_RESULT_TYPE));
	}

	public int getMatchCount() {
		return matchCount;
	}

	public long getReward() {
		return reward;
	}

	public boolean isBonusMatch() {
		return isBonusMatch;
	}

	public static List<LottoResultType> getReportTargets() {
		return Arrays.stream(LottoResultType.values())
			.filter(type -> type.getReward() > 0)
			.collect(Collectors.toList());
	}
}
