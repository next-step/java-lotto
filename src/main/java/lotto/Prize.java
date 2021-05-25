package lotto;

public enum Prize {
	SIX(6, new Money(2000000000)),
	FIVE(5, new Money(1500000)),
	FOUR(4, new Money(50000)),
	THREE(3, new Money(5000)),
	NOTHING(-1, new Money(0));

	private final int count;
	private final Money win;

	Prize(int count, Money winAmount) {
		this.count = count;
		this.win = winAmount;
	}

	public static Prize findByCount(int count) {
		Prize findResult = NOTHING;
		for (Prize prize : values()) {
			findResult = (prize.count() == count) ? prize : findResult;
		}
		return findResult;
	}

	public int count() {
		return count;
	}

	public Money win() {
		return win;
	}
}
