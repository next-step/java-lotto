package lotto.domain;

import java.util.StringJoiner;
import java.util.stream.Stream;

public enum LottoRank {
	FIRST(6, 0, new Amount(2_000_000_000)),
	SECOND(5, 1, new Amount(30_000_000)),
	THIRD(5, 0, new Amount(1_500_000)),
	FOURTH(4, 0, new Amount(50_000)),
	FIFTH(3, 0, new Amount(5_000)),
	NOTHING(0, 0, new Amount(0))
	;

	private final long sameQuantity;

	private final long bonusQuantity;
	private final Amount amount;

	LottoRank(long sameQuantity, long bonusQuantity, Amount amount) {
		this.sameQuantity = sameQuantity;
		this.bonusQuantity = bonusQuantity;
		this.amount = amount;
	}

	public static LottoRank findBySameQuantity(long sameQuantity, long bonusQuantity) {
		return Stream.of(LottoRank.values())
			.filter(rank -> rank.sameQuantity == sameQuantity && rank.bonusQuantity == bonusQuantity)
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
