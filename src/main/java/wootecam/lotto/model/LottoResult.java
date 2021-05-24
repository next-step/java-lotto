package wootecam.lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoResult {
	MISS(0, 0),
	FIFTH(3, 5_000),
	FOURTH(4, 50_000),
	THIRD(5, 1_500_000),
	SECOND(5, 30_000_000),
	FIRST(6, 2_000_000_000);

	private final int matchedCount;
	private final int winningMoney;

	LottoResult(int matchedCount, int winningMoney) {
		this.matchedCount = matchedCount;
		this.winningMoney = winningMoney;
	}

	public static List<LottoResult> getPrizeResult() {
		return Arrays.stream(LottoResult.values())
			.filter(lottoResult -> MISS != lottoResult)
			.collect(Collectors.toList());
	}

	public static LottoResult findByMatchedCount(int matchedCount, boolean isMatchedBonus) {

		if (checkSecond(matchedCount, isMatchedBonus)) {
			return SECOND;
		}

		return Arrays.stream(LottoResult.values())
			.filter(result -> result.matchedCount == matchedCount)
			.findFirst()
			.orElse(MISS);
	}

	private static boolean checkSecond(int matchedCount, boolean isMatchedBonus) {
		return matchedCount == 5 && isMatchedBonus;
	}

	public int getMatchedCount() {
		return matchedCount;
	}

	public int getWinningMoney() {
		return winningMoney;
	}
}
