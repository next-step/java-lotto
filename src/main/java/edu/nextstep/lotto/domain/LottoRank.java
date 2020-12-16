package edu.nextstep.lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
	FIRST(LottoNumbers.SIZE, 2000000000L),
	THIRD(LottoNumbers.SIZE - 1, 1500000L),
	FOURTH(LottoNumbers.SIZE - 2, 50000L),
	FIFTH(LottoNumbers.SIZE - 3, 5000L);

	private final int matchCount;
	private final long reward;

	LottoRank(int matchCount, long reward) {
		this.matchCount = matchCount;
		this.reward = reward;
	}

	public static Optional<LottoRank> from(int number) {
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.matchCount == number)
			.findFirst();
	}

	public int getMatchCount() {
		return matchCount;
	}

	public long getReward() {
		return reward;
	}
}