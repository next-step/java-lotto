package step2;

import java.util.Arrays;

public enum LottoWinning {
	THREE(3, 5000),
	FOUR(4, 50000),
	FIVE(5, 1500000),
	SIX(6, 2000000000)
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
				.orElse(null);
	}

	public int calcReward(int count) {
		return count * this.reward;
	}

}
