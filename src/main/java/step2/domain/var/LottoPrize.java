package step2.domain.var;

import java.util.Arrays;

public enum LottoPrize {
	CORRECT_ZERO(0, 0),
	CORRECT_ONE(1, 0),
	CORRECT_TWO(2, 0),
	FOURTH_WINNER(3, 5_000),
	THIRD_WINNER(4, 50_000),
	SECOND_WINNER(5, 1_500_000),
	FIRST_WINNER(6, 2_000_000_000);

	private final int count;
	private final int prize;

	LottoPrize(int count, int prize) {
		this.count = count;
		this.prize = prize;
	}

	public static LottoPrize getByCount(int count) {
		return Arrays
			.stream(LottoPrize.values())
			.filter((item) -> item.getCount() == count)
			.findFirst()
			.orElseThrow();
	}

	public int getCount() {
		return count;
	}

	public int getPrize() {
		return prize;
	}
}
