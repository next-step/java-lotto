package lotto.dto;

import java.math.BigDecimal;
import java.util.Map;

import lotto.domain.LottoRank;

public class LottoGameResultDto {
	private static final int LOTTO_PRICE = 1000;

	private final int lottoGameCount;
	private final BigDecimal profitRatio;
	private final Map<LottoRank, Long> lottoGameResult;

	public LottoGameResultDto(Map<LottoRank, Long> lottoGameResult, int lottoGameCount) {
		this.lottoGameResult = lottoGameResult;
		this.lottoGameCount = lottoGameCount;
		this.profitRatio = getProfitRatioValue();
	}

	public BigDecimal getProfitRatio() {
		return profitRatio;
	}

	public Map<LottoRank, Long> getLottoGameResult() {
		return lottoGameResult;
	}

	private BigDecimal getProfitRatioValue() {
		BigDecimal profit = BigDecimal.valueOf(lottoGameResult.entrySet().stream()
			.mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
			.sum());
		BigDecimal loss = BigDecimal.valueOf((long)lottoGameCount * LOTTO_PRICE);
		return profit.divide(loss, 2, BigDecimal.ROUND_HALF_UP);
	}
}
