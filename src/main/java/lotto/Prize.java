package lotto;

public enum Prize {
	FIRST(6, new Money(2_000_000_000)),
	SECOND(5, new Money(30_000_000)),
	THIRD(5, new Money(1_500_000)),
	FOURTH(4, new Money(50_000)),
	FIFTH(3, new Money(5_000)),
	NOTHING(0, new Money(0));

	private final int count;
	private final Money win;

	Prize(int count, Money winAmount) {
		this.count = count;
		this.win = winAmount;
	}

	public static Prize valueOf(int count, boolean matchBonus) {
		Prize result = NOTHING;
		for (Prize prize : values()) {
			result = isSameCount(count, prize) ? prize : result;
		}
		return isSecondPrize(result, matchBonus) ? Prize.SECOND : result;
	}

	private static boolean isSecondPrize(Prize prize, boolean matchBonus) {
		return prize.equals(Prize.THIRD) && matchBonus;
	}

	private static boolean isSameCount(int count, Prize prize) {
		return prize.count() == count;
	}

	public int count() {
		return count;
	}

	public Money win() {
		return win;
	}

	public static Profit profit(Statistics statistics) {
		int totalCount = statistics.totalCount();
		Money win = new Money(0);
		for (Prize prize : Prize.values()) {
			int count = statistics.status(prize);
			Money amount = prize.win().multiply(count);
			win = win.plus(amount);
		}
		return new Profit(win, Store.LOTTO_PRICE.multiply(totalCount));
	}
}
