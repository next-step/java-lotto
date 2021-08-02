package lottoautomatic.domain;

import java.util.Arrays;

public enum LottoProfit {

	THREE(3, 5000),
	FOUR(4, 50000),
	FIVE(5, 1500000),
	SIX(6, 2000000000);

	private final int quantity;
	private final long profitUnit;

	LottoProfit(int quantity, long profitUnit) {
		this.quantity = quantity;
		this.profitUnit = profitUnit;
	}

	public static LottoProfit from(int quantity) {
		return Arrays.stream(LottoProfit.values())
		             .filter(profit -> profit.quantity == quantity)
		             .findFirst()
		             .orElseThrow(IllegalArgumentException::new);
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
