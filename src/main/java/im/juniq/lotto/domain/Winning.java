package im.juniq.lotto.domain;

import java.util.Arrays;

public enum Winning {
	FIRST(6, false, 2000000000L),
	SECOND(5, true, 30000000L),
	THIRD(5, false, 1500000L),
	FOURTH(4, false, 50000L),
	FIFTH(3, false, 5000L),
	LOSING(2, false, 0L);

	private final int matchedCount;
	private final boolean matchedBonus;
	private final Long amount;

	Winning(int matchedCount, boolean matchedBonus, Long amount) {
		this.matchedCount = matchedCount;
		this.matchedBonus = matchedBonus;
		this.amount = amount;
	}

	public int matchedCount() {
		return matchedCount;
	}

	public Long amount() {
		return amount;
	}

	public static Winning findByMatchedCount(int numberOfMatchedWinningNumber, boolean matchedBonus) {
		return Arrays.stream(Winning.values()).filter(winning -> comparison(numberOfMatchedWinningNumber, matchedBonus, winning)).findFirst().orElse(LOSING);
	}

	private static boolean comparison(int numberOfMatchedWinningNumber, boolean matchedBonus, Winning winning) {
		return equalMatchedCount(numberOfMatchedWinningNumber, winning) && eligibleBonus(matchedBonus, winning)
			|| equalMatchedCount(numberOfMatchedWinningNumber, winning) && ineligibleBonus(winning);
	}

	private static boolean equalMatchedCount(int numberOfMatchedWinningNumber, Winning winning) {
		return winning.matchedCount == numberOfMatchedWinningNumber;
	}

	private static boolean eligibleBonus(boolean matchedBonus, Winning winning) {
		return winning.matchedBonus && matchedBonus;
	}

	private static boolean ineligibleBonus(Winning winning) {
		return !winning.matchedBonus;
	}
}
