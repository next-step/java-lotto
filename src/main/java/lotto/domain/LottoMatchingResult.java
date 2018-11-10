package lotto.domain;

import lotto.domain.common.Money;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoMatchingResult {
	private Map<LottoWinnerType, Long> lottoWinnerTypeCountMap;

	public LottoMatchingResult(Map<LottoWinnerType, Long> lottoWinnerTypeLongMap) {
		this.lottoWinnerTypeCountMap = lottoWinnerTypeLongMap;
	}

	public Long getWinnerCountByWinnerType(LottoWinnerType lottoWinnerType) {
		return lottoWinnerTypeCountMap.getOrDefault(lottoWinnerType, 0l);
	}

	public BigDecimal getProfitsRate() {
		return Money.calculateRate(getTotalProfits(), getTotalPurchaseAmount());
	}

	public Money getTotalPurchaseAmount() {
		Money totalPurchaseAmount = Money.ZERO;
		for (Long value : lottoWinnerTypeCountMap.values()) {
			Money purchaseAmount = LottoConstants.LOTTO_TICKET_AMOUNT.multiply(Money.of(value));
			totalPurchaseAmount = totalPurchaseAmount.add(purchaseAmount);
		}
		return totalPurchaseAmount;
	}

	public Money getTotalProfits() {
		Money totalProfits = Money.ZERO;
		for (Map.Entry<LottoWinnerType, Long> entry : lottoWinnerTypeCountMap.entrySet()) {
			Money profits = entry.getKey().getReward().multiply(entry.getValue());
			totalProfits = totalProfits.add(profits);
		}
		return totalProfits;
	}
}
