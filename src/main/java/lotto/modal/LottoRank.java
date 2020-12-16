package lotto.modal;

import java.util.Arrays;

public enum LottoRank {

	NOTHING_RANK(0, 0),
	FOURTH_RANK(3, 5000),
	THIRD_RANK(4, 50000),
	SECOND_RANK(5, 1500000),
	FIRST_RANK(6, 2000000000);

	private final int matchCount;
	private final int winnerPrize;
	private final String resultMsg;

	LottoRank(int matchCount, int winnerPrize) {
		this.matchCount = matchCount;
		this.winnerPrize = winnerPrize;
		this.resultMsg = matchCount + "개 일치 (" + winnerPrize + "원)-";
	}

	public static LottoRank getRank(int matchCount) {

		return Arrays.stream(values())
			.filter(lottoRank -> lottoRank.isMatch(matchCount))
			.findFirst()
			.orElse(NOTHING_RANK);
	}

	public int getWinnerPrize() {
		return winnerPrize;
	}

	public String getRankMessage() {
		return resultMsg;
	}

	private boolean isMatch(int matchCount) {

		return this.matchCount == matchCount;
	}
}
