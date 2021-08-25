package lotto.domain.type;

import java.util.Arrays;

public enum WinningType {
	FIRST(6, 2000000000),
	SECOND(5, 1500000),
	THIRD(4, 50000),
	FOURTH(3, 5000),
	MISMATCH(0, 0);

	private final int numberOfMatch;
	private final int winnings;

	WinningType(int numberOfMatch, int winnings) {
		this.numberOfMatch = numberOfMatch;
		this.winnings = winnings;
	}

	public static WinningType getWinningType(int numberOfMatch) {
		return Arrays.stream(WinningType.values())
			.filter(winningType -> winningType.numberOfMatch == numberOfMatch)
			.findFirst()
			.orElse(MISMATCH);
	}

	public int getNumberOfMatch() {
		return numberOfMatch;
	}

	public int getWinnings() {
		return winnings;
	}
}
