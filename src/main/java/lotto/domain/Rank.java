package lotto.domain;

import java.util.Arrays;

public enum Rank {
	FIRST(6, 1_000_000_000),
	SECOND(5, 40_000_000),
	THIRD(4, 2_000_000),
	FOURTH(3, 50_000),
	NOT(0, 0);

	private final int num;
	private final long amount;

	Rank(int num, int amount) {
		this.num = num;
		this.amount = amount;
	}

	public static Rank matchRank(int num) {
		return Arrays.stream(Rank.values())
			.filter(r -> r.equalNum(num))
			.findAny()
			.orElse(Rank.NOT);
	}

	private boolean equalNum(int num) {
		return this.num == num;
	}

	public int getNum() {
		return num;
	}

	public long getAmount() {
		return amount;
	}

	public long calcTotalAmount(Integer winners) {
		return this.amount * winners;
	}
}
