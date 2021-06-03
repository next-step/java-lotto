package lotto;

import java.util.Arrays;

public enum LottoPrize {

	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000);

	private long matchCount;
	private int winningAmount;

	public static LottoPrize getLottoPrizeFromMatchCount(long matchedNumberCount, boolean matchBonus) {
		return Arrays.stream(LottoPrize.values())
			.filter(it -> it.matchCount == matchedNumberCount)
			.map(it -> getLottoWin(it, matchBonus))
			.findFirst()
			.orElse(null);
	}

	LottoPrize(int matchCount, int winningAmount) {
		this.matchCount = matchCount;
		this.winningAmount = winningAmount;
	}

	public int getWinningAmount() {
		return winningAmount;
	}

	public long getMatchCount() {
		return matchCount;
	}

	public boolean isSecond() {
		return this == SECOND;
	}

	private static LottoPrize getLottoWin(LottoPrize lottoPrize, boolean matchBonus) {
		if (isJudgeBonus(lottoPrize) && matchBonus) {
			return SECOND;
		}

		if (isJudgeBonus(lottoPrize) && !matchBonus) {
			return THIRD;
		}
		return lottoPrize;
	}

	private static boolean isJudgeBonus(LottoPrize lottoPrize) {
		return lottoPrize == SECOND || lottoPrize == THIRD;
	}
}
