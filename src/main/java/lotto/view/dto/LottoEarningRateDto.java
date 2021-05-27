package lotto.view.dto;

import lotto.model.Rate;

public class LottoEarningRateDto {
	private static final int FLOOR_POS = 2;
	private static final double PROFIT_POINT = 1.0;

	private final double earningsRate;
	private final boolean isProfit;

	public LottoEarningRateDto(Rate earningsRate) {
		Rate floorRate = earningsRate.floor(FLOOR_POS);
		this.earningsRate = floorRate.getRate();
		this.isProfit = earningsRate.equalOrGreaterThan(PROFIT_POINT);
	}

	public double getEarningsRate() {
		return earningsRate;
	}

	public boolean isProfit() {
		return isProfit;
	}
}
