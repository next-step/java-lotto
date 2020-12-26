package lotto.dto;

import java.math.BigDecimal;
import java.util.Map;

import lotto.domain.LottoRank;

public class LottoGameResultDto {
	private final int lottoBuyMoney;
	private final double profitRatio;
	private final Map<LottoRank, Long> lottoGameResult;

	public LottoGameResultDto(Map<LottoRank, Long> lottoGameResult, int lottoBuyMoney) {
		this.lottoGameResult = lottoGameResult;
		this.lottoBuyMoney = lottoBuyMoney;
		this.profitRatio = getProfitRatioValue();
	}

	public double getProfitRatio() {
		return profitRatio;
	}

	public Map<LottoRank, Long> getLottoGameResult() {
		return lottoGameResult;
	}

	private double getProfitRatioValue() {
		BigDecimal profit = BigDecimal.valueOf(lottoGameResult.entrySet().stream()
			.mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
			.sum());
		BigDecimal loss = BigDecimal.valueOf(lottoBuyMoney);
		return profit.divide(loss, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
