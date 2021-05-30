package lotto;

import java.util.Arrays;

public enum LottoPrize {

	FIRST(6, 2_000_000_000, false),
	SECOND(5, 30_000_000, true),
	THIRD(5, 1_500_000, false),
	FOURTH(4, 50_000, false),
	FIFTH(3, 5_000, false);

	private long matchCount;
	private int winningAmount;
	private boolean hasBonusNumber;

	public static LottoPrize getLottoPrizeFromMatchCount(long matchedNumberCount, boolean matchBonus) {
		return Arrays.stream(LottoPrize.values())
			.filter(it -> it.matchCount == matchedNumberCount && it.hasBonusNumber == matchBonus)
			.findFirst()
			.orElse(null);
	}

	LottoPrize(int matchCount, int winningAmount, boolean hasBonusNumber) {
		this.matchCount = matchCount;
		this.winningAmount = winningAmount;
		this.hasBonusNumber = hasBonusNumber;
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
}
