package lotto.domain;

import java.util.Objects;

public class LotteryWinnings {
	private final int numberOfWins;

	public LotteryWinnings(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LotteryWinnings winnings = (LotteryWinnings)o;
		return numberOfWins == winnings.numberOfWins;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numberOfWins);
	}
}
