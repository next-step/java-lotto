package step2.model.lotto;

import java.util.Arrays;

public enum WinningAmount {
	THREE_MATCH(3, 5000),
	FOUR_MATCH(4, 50000),
	FIVE_MATCH(5, 1500000),
	SIX_MATCH(6, 2000000000);

	private int matchCount;
	private int prize;

	WinningAmount(int matchCount, int prize) {
		this.matchCount = matchCount;
		this.prize = prize;
	}

	public int getMatchCount() {
		return this.matchCount;
	}

	public int getPrize() {
		return this.prize;
	}

	public static WinningAmount findByMatchCount(int matchCount) {
		return Arrays.stream(values())
			.filter(winningAmount -> winningAmount.getMatchCount() == matchCount)
			.findAny()
			.orElseThrow(RuntimeException::new);
	}
}
