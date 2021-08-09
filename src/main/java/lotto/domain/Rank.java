package lotto.domain;

import java.util.function.Function;

public enum PrizeMoney {
	NO_MATCH(0, Money.from(0)),
	THREE_MATCH(3, Money.from(5000)),
	FOUR_MATCH(4, Money.from(50000)),
	FIVE_MATCH(5, Money.from(1500000)),
	SIX_MATCH(6, Money.from(2000000000));

	private final int matchCount;
	private final Money money;
	// private final Function<Integer, Integer> function;

	//PrizeMoney(int matchCount, Function<Integer, Integer> function) {
	PrizeMoney(int matchCount, Money money) {
		this.matchCount = matchCount;
		this.money = money;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public long getPrizeMoney(int lottoCount) {
		return this.function.apply(lottoCount);
	}
}
