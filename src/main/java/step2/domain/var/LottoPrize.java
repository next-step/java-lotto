package step2.domain.var;

public enum LottoPrize {
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

	public int getCount() {
		return count;
	}

	public int getPrize() {
		return prize;
	}
}
