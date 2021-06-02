package lotto;

import java.util.Arrays;

public enum Prize {
	FIRST(6, new Money(2_000_000_000), false),
	SECOND(5, new Money(30_000_000), true),
	THIRD(5, new Money(1_500_000), false),
	FOURTH(4, new Money(50_000), false),
	FIFTH(3, new Money(5_000), false),
	NOTHING(0, new Money(0), false);

	private final int count;
	private final Money win;
	private final boolean requiredBonusBall;

	Prize(int count, Money win, boolean requiredBonusBall) {
		this.count = count;
		this.win = win;
		this.requiredBonusBall = requiredBonusBall;
	}

	public static Prize valueOf(int count, boolean bonusBall) {
		return Arrays.stream(values())
			.filter(rank -> rank.isMatched(count, bonusBall))
			.findAny()
			.orElse(NOTHING);
	}

	private boolean isMatched(int count, boolean matchBonusBall) {
		return this.count == count && (!this.requiredBonusBall || matchBonusBall);
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
