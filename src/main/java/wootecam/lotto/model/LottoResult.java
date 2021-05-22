package wootecam.lotto.model;

import java.util.Arrays;

public enum LottoResult {
	DEFEAT(0, 0),
	THREE_MATCHING(3, 5_000),
	FOUR_MATCHING(4, 50_000),
	FIVE_MATCHING(5, 1_500_000),
	SIX_MATCHING(6, 2_000_000_000);

	private final int matchedCount;
	private final int winningMoney;

	LottoResult(int matchedCount, int winningMoney) {
		this.matchedCount = matchedCount;
		this.winningMoney = winningMoney;
	}

	public static LottoResult findByMatchedCount(int matchedCount) {
		return Arrays.stream(LottoResult.values())
			.filter(result -> result.matchedCount == matchedCount)
			.findAny()
			.orElse(DEFEAT);
	}

	public int getMatchedCount() {
		return matchedCount;
	}

	public int getWinningMoney() {
		return winningMoney;
	}
}
