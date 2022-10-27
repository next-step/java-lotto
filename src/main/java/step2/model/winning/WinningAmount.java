package step2.model.winning;

import java.util.Arrays;

public enum WinningAmount {

	THREE_MATCH(3, 5_000),
	FOUR_MATCH(4, 50_000),
	FIVE_MATCH(5, 1_500_000),
	SIX_MATCH(6, 2_000_000_000);

	private final int matchCount;		// 일치하는 개수
	private final int prize;				// 당첨 상금

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
