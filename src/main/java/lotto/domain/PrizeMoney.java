package lotto.domain;

import java.util.function.Function;

public enum PrizeMoney {
	NON_MATCH(0, (lottoCount) -> 0L),
	THREE_MATCH(3, (lottoCount) -> lottoCount * 5000L),
	FOUR_MATCH(4, (lottoCount) -> lottoCount * 50000L),
	FIVE_MATCH(5, (lottoCount) -> lottoCount * 1500000L),
	SIX_MATCH(6, (lottoCount) -> lottoCount * 2000000000L);

	private final int matchCount;
	private final Function<Integer, Long> function;

	public int getMatchCount() {
		return matchCount;
	}

	PrizeMoney(int matchCount, Function<Integer, Long> function) {
		this.matchCount = matchCount;
		this.function = function;
	}

	public long getPrizeMoney(int lottoCount) {
		return this.function.apply(lottoCount);
	}
}
