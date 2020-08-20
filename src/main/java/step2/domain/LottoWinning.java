package step2.domain;

import java.util.Arrays;

public enum LottoWinning {
	THREE(3, 5_000),
	FOUR(4, 50_000),
	FIVE(5, 1_500_000),
	SIX(6, 2_000_000_000),
	NOTTING(0, 0)
	;

	private final int matchingCount;
	private final int reward;

	LottoWinning(int matchingCount, int reward) {
		this.matchingCount = matchingCount;
		this.reward = reward;
	}

	public int getReward() {
		return reward;
	}

	public static LottoWinning of(int matchingCount) {
		return Arrays.stream(values())
				.filter(x -> x.matchingCount == matchingCount)
				.findFirst()
				.orElse(NOTTING);
	}

	public int calcReward(int count) {
		return count * this.reward;
	}

}
