package lotto.modal;

import java.util.Arrays;

public enum LottoRank {

	NOTHING_RANK(0, 0),
	FIFTH_RANK(3, 5_000),
	FOURTH_RANK(4, 50_000),
	THIRD_RANK(5, 1_500_000),
	SECOND_RANK(5, 30_000_000),
	FIRST_RANK(6, 2_000_000_000);

	private final int matchCount;
	private final int winnerPrize;

	LottoRank(int matchCount, int winnerPrize) {
		this.matchCount = matchCount;
		this.winnerPrize = winnerPrize;
	}

	public static LottoRank getRank(int matchCount, boolean hasBonusNumber) {
		return Arrays.stream(values())
			.filter(lottoRank -> lottoRank.isMatch(matchCount))
			.filter(lottoRank -> !(lottoRank.equals(THIRD_RANK) && hasBonusNumber))
			.findFirst()
			.orElse(NOTHING_RANK);
	}

	public int getWinnerPrize() {
		return winnerPrize;
	}

	public int getMatchCount() {
		return matchCount;
	}

	private boolean isMatch(int matchCount) {
		return this.matchCount == matchCount;
	}
}
