package lotto;

public enum Prize {
	SIX(6, 2000000000),
	FIVE(5, 1500000),
	FOUR(4, 50000),
	THREE(3, 5000),
	NOTHING(-1, 0);

	private final int count;
	private final long winAmount;

	Prize(int count, long winAmount) {
		this.count = count;
		this.winAmount = winAmount;
	}

	public static Prize getPrizeByCount(int count) {
		Prize findResult = NOTHING;
		for (Prize prize : values()) {
			findResult = (prize.count() == count) ? prize : findResult;
		}
		return findResult;
	}

	private int count() {
		return count;
	}

	public long winAmount() {
		return winAmount;
	}
}
