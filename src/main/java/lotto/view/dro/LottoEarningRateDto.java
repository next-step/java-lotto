package lotto.view.dro;

import lotto.model.Rate;

public class LottoEarningRateDto {
	private static final int FLOOR_POS = 2;
	private final double earningsRate;

	public LottoEarningRateDto(Rate earningsRate) {
		Rate floorRate = earningsRate.floor(FLOOR_POS);
		this.earningsRate = floorRate.getRate();
	}

	public double getEarningsRate() {
		return earningsRate;
	}
}
