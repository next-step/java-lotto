package step2.domain;

import java.math.BigDecimal;

public class LottoProfit {

	private final LottoPrice lottoPrice;
	private final LottoResults lottoResults;

	public LottoProfit(final LottoPrice lottoPrice, final LottoResults lottoResults) {
		this.lottoPrice = lottoPrice;
		this.lottoResults = lottoResults;
	}

	public Double getProfitRatio() {
		return BigDecimal.valueOf(lottoResults.getWinPrice())
			.divide(BigDecimal.valueOf(lottoPrice.getPurchasePrice()), 2, BigDecimal.ROUND_HALF_UP)
			.doubleValue();
	}
}
