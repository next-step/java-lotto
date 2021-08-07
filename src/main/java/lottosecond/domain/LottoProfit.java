package lottosecond.domain;

import java.util.Arrays;

public enum LottoProfit {

	ZERO(0, 0),
	THREE(3, 5_000),
	FOUR(4, 50_000),
	FIVE(5, 1_500_000),
	FIVE_BONUS(5, 30_000_000),
	SIX(6, 2_000_000_000);

	private final int quantity;
	private final long profitUnit;

	LottoProfit(int quantity, long profitUnit) {
		this.quantity = quantity;
		this.profitUnit = profitUnit;
	}

	public static LottoProfit of(int quantity, boolean matchBonus) {
		if (quantity == FIVE_BONUS.quantity && matchBonus) {
			return FIVE_BONUS;
		}
		return Arrays.stream(LottoProfit.values())
		             .filter(profit -> profit.quantity == quantity)
		             .findFirst()
		             .orElse(ZERO);
	}

	public long profit(int matchingCount) {
		return profitUnit * matchingCount;
	}

	public int getQuantity() {
		return quantity;
	}

	public long getProfitUnit() {
		return profitUnit;
	}

}
