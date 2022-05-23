package lotto.domain;

import java.util.StringJoiner;
import java.util.stream.Stream;

public enum LottoRank {
	FIRST(6, false, new Amount(2_000_000_000)),
	SECOND(5, true, new Amount(30_000_000)),
	THIRD(5, false, new Amount(1_500_000)),
	FOURTH(4, false, new Amount(50_000)),
	FIFTH(3, false, new Amount(5_000)),
	NOTHING(0, false, new Amount(0))
	;

	private final long sameQuantity;

	private final boolean checkBonusBall;
	private final Amount amount;

	LottoRank(long sameQuantity, boolean checkBonusBall, Amount amount) {
		this.sameQuantity = sameQuantity;
		this.checkBonusBall = checkBonusBall;
		this.amount = amount;
	}

	public static LottoRank findBySameQuantity(long sameQuantity, boolean matchBonus) {
		return Stream.of(LottoRank.values())
			.filter(rank -> rank.sameQuantity == sameQuantity && rank.checkBonusBall == matchBonus)
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

	public boolean checkBonus() {
		return checkBonusBall;
	}
}
