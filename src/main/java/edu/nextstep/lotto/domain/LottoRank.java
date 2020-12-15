package edu.nextstep.lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
	FIRST(LottoNumbers.SIZE),
	THIRD(LottoNumbers.SIZE - 1),
	FOURTH(LottoNumbers.SIZE - 2),
	FIFTH(LottoNumbers.SIZE - 3);

	private final int matchCount;

	LottoRank(int matchCount) {
		this.matchCount = matchCount;
	}

	public static Optional<LottoRank> from(int number) {
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.matchCount == number)
			.findFirst();
	}
}