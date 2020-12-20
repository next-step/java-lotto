package edu.nextstep.lotto.domain.sub;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiPredicate;

public enum LottoRank {

	FIRST(LottoNumbers.SIZE, 2_000_000_000L,
		(matchCount, isMatchBonus) -> matchCount == LottoNumbers.SIZE),

	SECOND(LottoNumbers.SIZE - 1, 30_000_000L,
		(matchCount, isMatchBonus) -> matchCount == LottoNumbers.SIZE - 1 && isMatchBonus),

	THIRD(LottoNumbers.SIZE - 1, 1_500_000L,
		(matchCount, isMatchBonus) -> matchCount == LottoNumbers.SIZE - 1 && !isMatchBonus),

	FOURTH(LottoNumbers.SIZE - 2, 50_000L,
		(matchCount, isMatchBonus) -> matchCount == LottoNumbers.SIZE - 2),

	FIFTH(LottoNumbers.SIZE - 3, 5_000L,
		(matchCount, isMatchBonus) -> matchCount == LottoNumbers.SIZE - 3),

	NONE(0, 0L,
		(matchCount, isMatchBonus) -> matchCount >= 0 && matchCount < LottoNumbers.SIZE - 3);

	private final BiPredicate<Integer, Boolean> isMatchRank;
	private final int matchCount;
	private final long reward;

	LottoRank(int matchCount, long reward, BiPredicate<Integer, Boolean> isMatchRank) {
		this.matchCount = matchCount;
		this.reward = reward;
		this.isMatchRank = isMatchRank;
	}

	public static Optional<LottoRank> valueOf(int matchCount, boolean isMatchBonus) {
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.isMatchRank.test(matchCount, isMatchBonus))
			.findAny();
	}

	public int getMatchCount() {
		return matchCount;
	}

	public long getReward() {
		return reward;
	}
}