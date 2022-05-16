package lotto.domain;

import java.util.StringJoiner;
import java.util.stream.Stream;

public enum LottoRank {
	FIRST(6, new Amount(2_000_000_000)),
	SECOND(5, new Amount(1_500_000)),
	THIRD(4, new Amount(50_000)),
	FOURTH(3, new Amount(5_000)),
	NOTHING(0, new Amount(0)),
	;

	private final long sameQuantity;
	private final Amount amount;

	LottoRank(long sameQuantity, Amount amount) {
		this.sameQuantity = sameQuantity;
		this.amount = amount;
	}

	public static LottoRank findBySameQuantity(long sameQuantity) {
		return Stream.of(LottoRank.values())
			.filter(rank -> rank.sameQuantity == sameQuantity)
			.findFirst()
			.orElse(LottoRank.NOTHING);
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
