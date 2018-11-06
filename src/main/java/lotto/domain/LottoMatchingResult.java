package lotto.domain;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoMatchingResult {
	private Map<LottoWinnerType, Long> lottoWinnerTypeIntegerMap;

	public LottoMatchingResult(Map<LottoWinnerType, Long> lottoWinnerTypeIntegerMap) {
		this.lottoWinnerTypeIntegerMap = lottoWinnerTypeIntegerMap;
	}

	public Long getWinnerCountByWinnerType(LottoWinnerType lottoWinnerType) {
		return lottoWinnerTypeIntegerMap.getOrDefault(lottoWinnerType, 0l);
	}

	public BigDecimal getProfitsRate() {
		BigDecimal profitRate = new BigDecimal((double) getTotalProfits() / getTotalPurchaseAmount());
		return profitRate.setScale(2, BigDecimal.ROUND_DOWN);
	}

	public int getTotalPurchaseAmount() {
		int totalPurchaseAmount = 0;
		for (Long value : lottoWinnerTypeIntegerMap.values()) {
			totalPurchaseAmount += value * Lotto.LOTTO_TICKET_AMOUNT;
		}
		return totalPurchaseAmount;
	}

	public int getTotalProfits() {
		int totalProfits = 0;
		for (Map.Entry<LottoWinnerType, Long> entry : lottoWinnerTypeIntegerMap.entrySet()) {
			totalProfits += entry.getKey().getReward() * entry.getValue();
		}
		return totalProfits;
	}
}
