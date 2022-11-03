package step3;

import java.util.Arrays;

public enum Operator {
	NOT_RANK(0, null, 0),
	THREE(3, false, 5_000),
	FOUR(4, false, 50_000),
	FIVE(5, false, 1_500_000),
	FIVE_BONUS(5, true, 30_000_000),
	SIX(6, false, 2_000_000_000);

	private int count;
	private int winning;
	private Boolean bonusCheck;

	Operator(int count, Boolean bonusCheck, int winning) {
		this.count = count;
		this.bonusCheck = bonusCheck;
		this.winning = winning;
	}

	public static Operator find(int count, boolean bonus) {
		return Arrays.stream(values())
			.filter(ranks -> isRank(ranks, count, bonus))
			.findFirst()
			.orElse(NOT_RANK);
	}

	private static boolean isRank(Operator rank, int count, boolean bonus) {
		if (rank.bonusCheck != null) {
			return rank.count == count && rank.bonusCheck == bonus;
		}
		return rank.count == count;
	}

	public int getCount() {
		return count;
	}

	public int getWinning() {
		return winning;
	}
}
