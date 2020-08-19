package step2;

import java.util.Arrays;

public enum LottoWinning {
	THREE(3, 5_000),
	FOUR(4, 50_000),
	FIVE(5, 1_500_000),
	SIX(6, 2_000_000_000)
	;

	private final int matchingCount;
	private final int reward;

	LottoWinning(int matchingCount, int reward) {
		this.matchingCount = matchingCount;
		this.reward = reward;
	}

	public int getMatchingCount() {
		return matchingCount;
	}

	public int getReward() {
		return reward;
	}

	public static LottoWinning of(int winningCount) {
		return Arrays.stream(values())
				.filter(x -> x.matchingCount == winningCount)
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	public int calcReward(int count) {
		return count * this.reward;
	}

}
