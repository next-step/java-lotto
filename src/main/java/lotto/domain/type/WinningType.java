package lotto.domain.type;

import java.util.Arrays;

public enum WinningType {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISMATCH(0, 0);

	private final int numberOfMatch;
	private final int winnings;

	WinningType(int numberOfMatch, int winnings) {
		this.numberOfMatch = numberOfMatch;
		this.winnings = winnings;
	}

	public static WinningType getWinningType(int numberOfMatch, boolean matchBonus) {
		WinningType winningType = Arrays.stream(WinningType.values())
			.filter(type -> type.numberOfMatch == numberOfMatch)
			.findFirst()
			.orElse(MISMATCH);

		if (winningType == SECOND && !matchBonus) {
			return THIRD;
		}

		return winningType;
	}

	public int getNumberOfMatch() {
		return numberOfMatch;
	}

	public int getWinnings() {
		return winnings;
	}
}
