package lotto.domain.result;

import lotto.domain.input.Money;
import lotto.model.LottoPrizePolicy;

public class LottoPrizeAnalysisResult {

	private Money totalPrizeMoney;

	private EarningsRate earningsRate;

	//어떤 기능이 있는지 빠르게 파악할 수 있도록 public 주요 메서드를 상단에 배치
	public void arrangePrize(LottoMatchResultList lottoMatchCountResult, Money lottoPricePerSheet) {
		this.totalPrizeMoney = new Money(0);
		this.earningsRate = new EarningsRate();
		for (MatchResultPerLotto lottoResult : lottoMatchCountResult.getLottoMatchResults()) {
			this.totalPrizeMoney = calculateLottoPrize(lottoResult,this.totalPrizeMoney);
		}
		this.earningsRate.calculateEarningsRate(totalPrizeMoney, lottoMatchCountResult.getLottoMatchResults(), lottoPricePerSheet);

	}

	private Money calculateLottoPrize(MatchResultPerLotto matchResultPerLotto, Money totalPrizeMoney) {
		return LottoPrizePolicy.getPrizeMoney(matchResultPerLotto, totalPrizeMoney);
	}

	public EarningsRate getEarningsRate() {
		return earningsRate;
	}

	public Money getTotalPrizeMoney() {
		return totalPrizeMoney;
	}
}