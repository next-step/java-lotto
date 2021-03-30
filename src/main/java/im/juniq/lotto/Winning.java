package im.juniq.lotto;

import java.util.HashMap;
import java.util.Map;

public enum Winning {
	FIRST(6, false, 2000000000L),
	SECOND(5, true, 30000000L),
	THIRD(5, false, 1500000L),
	FOURTH(4, false, 50000L),
	FIFTH(3, false, 5000L),
	LOSING(2, false, 0L);

	private int matchedCount;
	private boolean matchedBonus;
	private Long amount;

	Winning(int matchedCount, boolean matchedBonus, Long amount) {
		this.matchedCount = matchedCount;
		this.matchedBonus = matchedBonus;
		this.amount = amount;
	}

	private static Winning getWinning(int numberOfMatchedWinningNumber, Map<Integer, Winning> map) {
		Winning gottenWinning = map.get(numberOfMatchedWinningNumber);
		if (gottenWinning == null) {
			return LOSING;
		}
		return gottenWinning;
	}

	public static Winning findByMatchedCount(int numberOfMatchedWinningNumber, boolean matchedBonus) {
		for (Winning winning : Winning.values()) {
			if (winning.matchedCount == numberOfMatchedWinningNumber) {
				if (winning.matchedBonus && matchedBonus) {
					return winning;
				}
				if (!winning.matchedBonus) {
					return winning;
				}
			}
		}
		return Winning.LOSING;
	}

	public Long amount() {
		return amount;
	}

	public int matchedCount() {
		return matchedCount;
	}
}
