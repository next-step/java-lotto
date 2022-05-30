package lotto.domain;

import java.util.stream.Stream;

public enum LottoRank {
	FIRST(6, new Amount(2_000_000_000)),
	SECOND(5, new Amount(30_000_000)),
	THIRD(5, new Amount(1_500_000)),
	FOURTH(4, new Amount(50_000)),
	FIFTH(3, new Amount(5_000)),
	NOTHING(0, new Amount(0))
	;

	private final long sameQuantity;
	private final Amount amount;

	LottoRank(long sameQuantity, Amount amount) {
		this.sameQuantity = sameQuantity;
		this.amount = amount;
	}

	public static LottoRank findBySameQuantity(long sameQuantity, boolean matchBonus) {
		if (isSecond(sameQuantity, matchBonus)) {
			return LottoRank.SECOND;
		}

		return Stream.of(LottoRank.values())
			.filter(rank -> LottoRank.SECOND != rank)
			.filter(rank -> rank.sameQuantity == sameQuantity)
			.findAny()
			.orElse(NOTHING);
	}

	private static boolean isSecond(long sameQuantity, boolean matchBonus) {
		return LottoRank.SECOND.sameQuantity == sameQuantity && matchBonus;
	}

	public boolean isStatistics() {
		return this != LottoRank.NOTHING;
	}

	public long amount() {
		return amount.value();
	}

	public long sameQuantity() {
		return sameQuantity;
	}

	@Override
	public String toString() {
		return this.name() + "{" +
			"sameQuantity=" + sameQuantity +
			", amount=" + amount +
			'}';
	}
}
