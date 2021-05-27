package lotto;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoPrizeType {
	NO_MATCHED(0, BigDecimal.ZERO),
	FIFTH(3, BigDecimal.valueOf(5_000)),
	FOURTH(4, BigDecimal.valueOf(50_000)),
	THIRD(5, BigDecimal.valueOf(1_500_000)),
	SECOND(5, BigDecimal.valueOf(30_000_000)),
	FIRST(6, BigDecimal.valueOf(2_000_000_000));

	private static final int MAXIMUM_MATCHED_NUMBER = 6;
	private static final int MINIMUM_WINNING_MATCHED_NUMBER = 3;

	private final int matchedNumberCount;
	private final BigDecimal prizeMoney;

	LottoPrizeType(int matchedNumberCount, BigDecimal prizeMoney) {
		this.matchedNumberCount = matchedNumberCount;
		this.prizeMoney = prizeMoney;
	}

	public static LottoPrizeType valueByMatchedNumberCount(int matchedNumberCount, boolean bonusBallMatched) {
		return Arrays.stream(LottoPrizeType.values())
				.filter(it -> filterPrize(matchedNumberCount, bonusBallMatched, it))
				.findFirst()
				.orElse(NO_MATCHED);
	}

	private static boolean filterPrize(int matchedNumberCount, boolean bonusBallMatched, LottoPrizeType it) {
		if (it.matchedNumberCount == matchedNumberCount) {
			return it != THIRD || !bonusBallMatched;
		}
		return false;
	}

	public boolean isWinningType() {
		return matchedNumberCount <= MAXIMUM_MATCHED_NUMBER && matchedNumberCount >= MINIMUM_WINNING_MATCHED_NUMBER;
	}

	public int getMatchedNumberCount() {
		return matchedNumberCount;
	}

	public BigDecimal getPrizeMoney() {
		return prizeMoney;
	}
}
